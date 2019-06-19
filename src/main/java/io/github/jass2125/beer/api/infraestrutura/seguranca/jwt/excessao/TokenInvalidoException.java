package io.github.jass2125.beer.api.infraestrutura.seguranca.jwt.excessao;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 * Created on 9 de ago de 2018
 * @project bids-api
 *
 *
 */
public class TokenInvalidoException extends RuntimeException {

    /**
     *
     */
    public TokenInvalidoException() {
        super();
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public TokenInvalidoException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public TokenInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public TokenInvalidoException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public TokenInvalidoException(Throwable cause) {
        super(cause);
    }

}
