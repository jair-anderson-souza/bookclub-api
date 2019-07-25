package io.github.jass2125.beer.api.user.exceptions;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String msg) {
        super(msg);
    }
    
}
