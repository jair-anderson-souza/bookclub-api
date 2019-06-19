package io.github.jass2125.beer.api.usuario.recuperacao.Excessao.manipuladorExcessao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.github.jass2125.beer.api.usuario.recuperacao.senha.Excessao.SenhaInvalidaException;
import io.github.jass2125.beer.api.infraestrutura.seguranca.jwt.excessao.TokenInvalidoException;
import io.github.jass2125.beer.api.usuario.excessao.UsuarioNaoCadastradoException;
import io.github.jass2125.beer.api.usuario.recuperacao.Excessao.TokenExpiradoException;



/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 *         Created on 13 de jun de 2018
 * @project bids-api
 *
 **/
@ControllerAdvice
public class RecuperacaoManipuladorExcessao extends ResponseEntityExceptionHandler {

	private static final class MensagemErro {
		public static final String TOKEN_INVALIDO = "O link que você acessou é inválido ou já foi utilizado, por favor,  solicite novamente a recuperação de senha.";
		public static final String TOKEN_EXPIRADO = "Este link já expirou, por favor, solicite novamente a recuperação de senha.";
		public static final String SENHA_INVÁLIDA = "A senha informada é inválida, a senha deve ser Alfanumérica contendo entre 8 e 30 caracteres.";
		public static final String USUARIO_NAO_ENCONTRADO = "Não foi encontrado usuários com esse email.";
	}

	@ExceptionHandler({ TokenInvalidoException.class })
	public ResponseEntity<Object> handleBadRequest(final TokenInvalidoException ex) {
		return ResponseEntity.badRequest().body(MensagemErro.TOKEN_INVALIDO);
	}

	@ExceptionHandler({ TokenExpiradoException.class })
	public ResponseEntity<Object> handleBadRequest(final TokenExpiradoException ex) {
		return ResponseEntity.badRequest().body(MensagemErro.TOKEN_EXPIRADO);
	}

	@ExceptionHandler({ SenhaInvalidaException.class })
	public ResponseEntity<Object> handleBadRequest(final SenhaInvalidaException ex) {
		return ResponseEntity.badRequest().body(MensagemErro.SENHA_INVÁLIDA);
	}
	
	@ExceptionHandler({ UsuarioNaoCadastradoException.class })
	public ResponseEntity<Object> handleBadRequest(final UsuarioNaoCadastradoException ex) {
		return ResponseEntity.badRequest().body(MensagemErro.USUARIO_NAO_ENCONTRADO);
	}


}
