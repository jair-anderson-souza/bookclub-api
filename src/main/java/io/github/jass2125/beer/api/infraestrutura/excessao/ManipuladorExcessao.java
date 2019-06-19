package io.github.jass2125.beer.api.infraestrutura.excessao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.github.jass2125.beer.api.usuario.excessao.UsuarioJaExisteException;


@Primary
@Configuration
@ControllerAdvice
public class ManipuladorExcessao extends ResponseEntityExceptionHandler {

    /**
     * Retorna um JSON com a lista de invalidações encontradas
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        ex.printStackTrace();

        List<String> erros = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity(erros, headers, status);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolationException(final ConstraintViolationException ex,
            final WebRequest request) {

        ex.printStackTrace();

        final List<String> errors = new ArrayList<String>();
        for (final ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
                    + violation.getMessage());
        }

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler({TransactionSystemException.class})
    public ResponseEntity<Object> handleTransactionSystemException(TransactionSystemException ex) {
        final List<String> errors = new ArrayList<String>();

        ex.printStackTrace();

        // getCause 2x pois primeiro vem o RollbackException
        Throwable t = ex.getCause().getCause();
        if (t instanceof ConstraintViolationException) {
            ConstraintViolationException cve = (ConstraintViolationException) t;
            final Set<ConstraintViolation<?>> constraintViolations = cve.getConstraintViolations();
            for (final ConstraintViolation<?> violation : constraintViolations) {
                errors.add(violation.getMessage());
            }

        } else {
            ex.printStackTrace();
        }

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(UsuarioJaExisteException.class)
    public ResponseEntity<List<String>> handleUsuarioJaExisteException(UsuarioJaExisteException e) {

        final List<String> body = Arrays.asList(e.getMessage());

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return ResponseEntity.badRequest().headers(headers).body(body);
    }

}
