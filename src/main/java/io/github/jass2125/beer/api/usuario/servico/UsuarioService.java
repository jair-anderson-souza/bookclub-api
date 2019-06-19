package io.github.jass2125.beer.api.usuario.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.github.jass2125.beer.api.infraestrutura.seguranca.jwt.JwtTokenProvider;
import io.github.jass2125.beer.api.infraestrutura.seguranca.usuario.MyAuthUser;
import io.github.jass2125.beer.api.usuario.Usuario;
import io.github.jass2125.beer.api.usuario.infraestrutura.UsuarioRepositorio;

@Service
public class UsuarioService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public String login(final String email, final String password) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        return jwtTokenProvider.createToken(usuarioRepositorio.findByEmail(email));
    }

    public MyAuthUser getMyAuthUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        MyAuthUser usuarioLogado;
        try {
            usuarioLogado = (MyAuthUser) authentication.getPrincipal();
        } catch (ClassCastException ex) {
            return null;
        }

        return usuarioLogado;
    }

    public Usuario getUsuarioLogado() {
        final MyAuthUser myAuthUser = getMyAuthUser();
        if (myAuthUser == null) {
            return null;
        }

        final Usuario usuario = usuarioRepositorio.findOne(myAuthUser.getId());

        return usuario;
    }

    public Usuario getByEmail(final String email) {
        final Usuario usuario = this.usuarioRepositorio.findByEmail(email);

        return usuario;
    }

}
