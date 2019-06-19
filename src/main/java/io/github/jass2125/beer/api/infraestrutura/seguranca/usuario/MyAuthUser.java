//package io.github.jass2125.beer.api.infraestrutura.seguranca.usuario;
//
//import java.util.Arrays;
//import java.util.Objects;
//import org.springframework.security.core.userdetails.User;
//
//
//public class MyAuthUser extends User {
//
//    private Long id;
//    private String email;
//    private String nome;
//
//    public MyAuthUser(String nome, String perfil) {
//        super(nome, "", Arrays.asList(null));
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 79 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final MyAuthUser other = (MyAuthUser) obj;
//        return Objects.equals(this.id, other.id);
//    }
//
//    @Override
//    public String toString() {
//        return "MyAuthUser{" + "id=" + id + ", email=" + email + ", nome=" + nome + '}';
//    }
//
//}
