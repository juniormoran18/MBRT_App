package com.example.junior.practica.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junior.practica.R;
import com.example.junior.practica.model.User;
import com.example.junior.practica.repository.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView user;
    TextView password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.userTxt);
        password = (EditText) findViewById(R.id.passTxt);

    }

    public void login(View view){

        String usua = user.getText().toString();
        String contraseña = password.getText().toString();

        if(usua.isEmpty() || contraseña.isEmpty()){
            Toast.makeText(this,"Faltan completar campos", Toast.LENGTH_SHORT).show();
        }else{
            Usuario usuario = Usuario.getInstance();
            List<User> usuarios = usuario.getUsers();
            boolean check = true;

            for (final User usuarioCreado : usuarios){
                if (usua.equals(usuarioCreado.getUsername()) && contraseña.equals(usuarioCreado.getPassword())){
                    check = true;
                    Intent i = new Intent(MainActivity.this, cliente.class);
                        String rol = usuarioCreado.getRol();
                        i.putExtra("Ingresado",rol);
                        startActivity(i);
                        break;
                    }else {
                    check = false;
                }
                }
                if(!check){
                    Toast.makeText(this, "error:datos incorrectos ", Toast.LENGTH_SHORT).show();
                }
            }

        }

    }
