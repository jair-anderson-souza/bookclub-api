package io.github.jass2125.beer.api.model.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    CLIENT;

    @Override
    public String getAuthority() {
        return this.name();
    }

}
