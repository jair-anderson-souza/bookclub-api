package io.github.jass2125.beer.api.user.service;

import io.github.jass2125.beer.api.model.user.User;
import io.github.jass2125.beer.api.security.JwtTokenProvider;
import io.github.jass2125.beer.api.user.exceptions.EmailExistsException;
import io.github.jass2125.beer.api.user.exceptions.LoginException;
import io.github.jass2125.beer.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            return jwtTokenProvider.createToken(userRepository.findByUsername(user.getUsername()));
        } catch (AuthenticationException e) {
            throw new LoginException("Dados inválidos");
        }
    }

    public void save(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } else {
            throw new EmailExistsException("Email já está em uso");
        }
    }

}
