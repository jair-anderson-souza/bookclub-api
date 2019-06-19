package io.github.jass2125.beer.api.usuario;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "t_usuario")
@SequenceGenerator(name = "t_usuario_seq", sequenceName = "t_usuario_seq", allocationSize = 1)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_usuario_seq")
    private Integer id;

    @NotNull(message = "O usuário deve possuir um nome")
    private String nome;

    @NotNull(message = "O usuário deve possuir um e-mail")
    private String email;

    @NotEmpty(message = "O usuario deve possuir uma senha")
    @Length(min = 8, max = 255, message = "A senha deve possuir no mínimo 8 caracteres e no máximo 30 caracteres alfanuméricos")
    private String senha;

    @NotEmpty(message = "O usuario deve possuir uma senha")
    @Length(min = 8, max = 255, message = "A senha deve possuir no mínimo 8 caracteres e no máximo 30 caracteres alfanuméricos")
    private String perfil;

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", perfil=" + perfil + '}';
    }

}
