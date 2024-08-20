package com.student.listadecontatos_main;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String username;
    private String email;
    private String password;

    public Usuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Usuario(Usuario u) {
        this.username = u.username;
        this.email = u.email;
        this.password = u.password;
    }

    public Usuario() {
        this.username = "";
        this.email = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }
}
