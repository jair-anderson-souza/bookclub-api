package io.github.jass2125.beer.api.infraestrutura.seguranca.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 *         Created on 4 de jun de 2018
 * @project bids-api
 *
 *          Filtro que faz a validação dos tokens JWT recebidos
 **/
public class JwtTokenFilter extends OncePerRequestFilter {

	private JwtTokenProvider jwtTokenProvider;

	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {

		String token = jwtTokenProvider.resolveToken(req);
		if (token != null && !token.equals("") && jwtTokenProvider.validateToken(token)) {
			Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
			SecurityContextHolder.getContext().setAuthentication(auth);
		}

		filterChain.doFilter(req, res);
	}

}
