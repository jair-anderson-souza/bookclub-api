/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.beer.api.infraestrutura.seguranca.usuario;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 * Created on 5 de jun de 2018
 * @project bids-api
 *
 * Classe que encapsula os dados necessarios para login
 *
 */
public class CredenciaisConta {

    @NotEmpty(message = "O usário deve possuir um e-mail")
    private String email;

    @NotEmpty(message = "O usuario deve possuir uma senha")
    @Length(min = 8, max = 30, message = "A senha deve possuir no mínimo 8 caracteres e no máximo 30 caracteres alfanuméricos")
    private String senha;

    public CredenciaisConta() {
    }

    public CredenciaisConta(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CredenciaisConta other = (CredenciaisConta) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.senha, other.senha);
    }

    @Override
    public String toString() {
        return "CredenciaisConta{" + "email=" + email + ", senha=" + senha + '}';
    }

}
