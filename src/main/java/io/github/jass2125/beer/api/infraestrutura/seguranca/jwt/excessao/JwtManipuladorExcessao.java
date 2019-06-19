package io.github.jass2125.beer.api.infraestrutura.seguranca.jwt.excessao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 *         Created on 9 de ago de 2018
 * @project bids-api
 *
 **/
@ControllerAdvice
public class JwtManipuladorExcessao extends ResponseEntityExceptionHandler {

	private static final class MensagemErro {
		protected static final String TOKEN_INVALIDO = "É necessário estar autenticado no sistema para realizar o acesso, realize o login no sistema";
	}

	@ExceptionHandler({ TokenInvalidoException.class })
	public ResponseEntity<Object> handleBadRequest(final TokenInvalidoException ex, final WebRequest request) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(MensagemErro.TOKEN_INVALIDO);
	}

}
