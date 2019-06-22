/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.beer.api.model.user;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author jairanderson
 */
public enum Role implements GrantedAuthority {

    CLIENT;

    @Override
    public String getAuthority() {
        return this.name();
    }
    
}
