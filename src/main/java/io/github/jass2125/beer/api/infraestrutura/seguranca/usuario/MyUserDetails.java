package io.github.jass2125.beer.api.infraestrutura.seguranca.usuario;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.jass2125.beer.api.usuario.Usuario;
import io.github.jass2125.beer.api.usuario.servico.UsuarioService;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Usuario usuario = usuarioService.getByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("User '" + email + "' not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getPerfil()));

        final MyAuthUser myAuthUser = new MyAuthUser(usuario.getNome(), usuario.getPerfil());

        return myAuthUser;
    }

}
