package com.example.junior.practica.model;

/**
 * Created by Junior on 25/09/17.
 */

public class User {

    private String username;
    private String password;
    private String nombres;
    private String rol;


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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    public User(String username, String password, String nombres, String rol) {
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.rol = rol;
    }
}
