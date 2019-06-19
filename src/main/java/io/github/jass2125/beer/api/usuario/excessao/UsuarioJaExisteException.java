package io.github.jass2125.beer.api.usuario.excessao;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 *         Created on 21 de ago de 2018
 * @project bids-api
 *
 *
 */
public class UsuarioJaExisteException extends RuntimeException {

	private static final long serialVersionUID = 5820998760718272287L;

	public UsuarioJaExisteException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UsuarioJaExisteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UsuarioJaExisteException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UsuarioJaExisteException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UsuarioJaExisteException(Throwable cause) {
		super(cause);
	}

}
