package com.portafolio.control.dto;

public class UsuarioLogin {

    private String email;
    private String password;

    public UsuarioLogin(String email) {
        this.email = email;
    }

    public UsuarioLogin() {
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
}
