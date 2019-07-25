package io.github.jass2125.beer.api.exceptions;

import io.github.jass2125.beer.api.beer.exceptions.IdInvalidoException;
import io.github.jass2125.beer.api.security.exceptions.TokenExpiratedException;
import io.github.jass2125.beer.api.user.exceptions.EmailExistsException;
import io.github.jass2125.beer.api.user.exceptions.LoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler({IdInvalidoException.class})
    public ResponseEntity<Object> handleIdInvalidoException(IdInvalidoException ex, WebRequest request) {

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler({EmailExistsException.class})
    public ResponseEntity<Object> handleEmailExistsException(EmailExistsException ex, WebRequest request) {

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler({TokenExpiratedException.class})
    public ResponseEntity<Object> handleTokenExpiratedException(TokenExpiratedException ex, WebRequest request) {

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> erros = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity(erros, headers, status);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolationException(final ConstraintViolationException ex,
            final WebRequest request) {

        final List<String> errors = new ArrayList<>();
        ex.getConstraintViolations().stream().forEach((violation) -> {
            errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
                    + violation.getMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

}
