package io.github.jass2125.beer.api.usuario.recuperacao.senha.Excessao;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 * Created on 13 de jun de 2018
 * @project bids-api
 *
 *
 */
public class SenhaInvalidaException extends RuntimeException {

    /**
     *
     */
    public SenhaInvalidaException() {
        super();
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public SenhaInvalidaException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public SenhaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public SenhaInvalidaException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public SenhaInvalidaException(Throwable cause) {
        super(cause);
    }

}
