package com.example.junior.practica.repository;

import com.example.junior.practica.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 25/09/17.
 */

public class Usuario {

    private static Usuario _INSTANCE = null;

            public static Usuario getInstance(){
                if(_INSTANCE == null)
                    _INSTANCE = new Usuario();
                return _INSTANCE;
            }

    private Usuario(){

        agregarUser(new User("cliente","1234","Marco","cliente"));
        agregarUser(new User("supervisor","1234","Pedro","supervisor"));
        agregarUser(new User("tecnico","1234","Luis","tecnico"));

    }

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {return this.users;}

    public void agregarUser(User user){
        this.users.add(user);
    }




}
