package io.github.jass2125.beer.api.model.user;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t_users")
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "O nome deve ser preenchido")
    private String name;
    @NotEmpty(message = "O nome de usuário deve ser preenchido")
    private String username;
    @NotEmpty(message = "A senha deve ser preenchida")
    private String password;
    @NotEmpty(message = "O perfil deve ser preenchido")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", roles=" + roles + '}';
    }

}
