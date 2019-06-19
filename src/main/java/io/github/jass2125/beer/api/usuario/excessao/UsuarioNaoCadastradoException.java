package io.github.jass2125.beer.api.usuario.excessao;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 *         Created on 13 de jun de 2018
 * @project bids-api
 *
 *
 */
public class UsuarioNaoCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 3856438176291574979L;

	public UsuarioNaoCadastradoException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UsuarioNaoCadastradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UsuarioNaoCadastradoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UsuarioNaoCadastradoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UsuarioNaoCadastradoException(Throwable cause) {
		super(cause);
	}

}
