package io.github.jass2125.beer.api.security.exceptions;

public class TokenExpiratedException extends RuntimeException {

    public TokenExpiratedException(String msg) {
    super(msg);
    }
    
    

}
