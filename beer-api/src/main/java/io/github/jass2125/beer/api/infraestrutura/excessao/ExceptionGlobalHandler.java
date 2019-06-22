package io.github.jass2125.beer.api.infraestrutura.excessao;

import io.github.jass2125.beer.api.security.LoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({LoginException.class})
    public ResponseEntity<Object> handleLoginException(LoginException ex, WebRequest request) {

        final List<String> errors = new ArrayList<String>();

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

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

}