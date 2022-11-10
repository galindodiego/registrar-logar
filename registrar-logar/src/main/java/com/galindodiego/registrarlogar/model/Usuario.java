package com.galindodiego.registrarlogar.model;

import javax.persistence.*;
import java.util.Objects;

@Entity // Anotação para persistencia
@Table(name = "usuarios") // Nome da tabela
public class Usuario {

    @Id//Anotação que o campo será ID unico na persistencia
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotacao auto incremento
    private Integer id;

    private String nome;

    private String login;

    private String password;

    private String email;

    public Integer getId() {
        return id;
    } // metodo retorna o valor da variavel Id

    public void setId(Integer id) {
        this.id = id;
    } //metodo define o valor da variavel id

    public String getNome() {
        return nome;
    } // metodo retorna o valor da variavel nome

    public void setNome(String nome) {
        this.nome = nome;
    }//metodo define o valor da variavel nome

    public String getLogin() {
        return login;
    } // metodo retorna o valor da variavel login

    public void setLogin(String login) {
        this.login = login;
    }//metodo define o valor da variavel login

    public String getPassword() {
        return password;
    } // metodo retorna o valor da variavel password

    public void setPassword(String password) {
        this.password = password;
    }//metodo define o valor da variavel password

    public String getEmail() {
        return email;
    } // metodo retorna o valor da variavel email

    public void setEmail(String email) {
        this.email = email;
    }//metodo define o valor da variavel email

    @Override
    public boolean equals(Object o) {// Metodo equals sobre-escrito para comparação em variaveis do mesmo tipo
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(login, usuario.login) && Objects.equals(password, usuario.password) && Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() { //Metodo hashCode sobre-escrito
        return Objects.hash(id, nome, login, password, email);
    }

    @Override
    public String toString() {//Metodo toString sobre-escrito
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
