package com.example.junior.practica.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.junior.practica.R;

public class cliente extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        //Inhabilitar las opciones del menu
        String rol = this.getIntent().getExtras().getString("Ingresado");
        if (rol.equals("cliente")) {
            itemsCliente();
        }else if(rol.equals("supervisor")){
            itemsSupervisor();
        }else {
            itemsTecnico();
        }

        // Set DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set drawer toggle icon
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }


        // Set NavigationItemSelectedListener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // Do action by menu item id
                switch (menuItem.getItemId()){
                    case R.id.nav_registrar:
                        Toast.makeText(cliente.this, "resgistrar", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_estado:
                        Toast.makeText(cliente.this, "Ver estado", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_consulta_todos:
                        Toast.makeText(cliente.this, "Consultar todos", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_asignar:
                        Toast.makeText(cliente.this, "Asignar a tecnico", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_reporte:
                        Toast.makeText(cliente.this, "Go settings...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_consulta_asignados:
                        Toast.makeText(cliente.this, "Do logout...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_atender:
                        Toast.makeText(cliente.this, "Do logout...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_profile:
                        Toast.makeText(cliente.this, "Perfil", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(cliente.this, "Configuración", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        Toast.makeText(cliente.this, "Cerrar Sesión", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(cliente.this, MainActivity.class));
                        break;

                }

                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }



    private void itemsCliente() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);// Colocas el id de tu NavigationView
        Menu miMenu= navigationView.getMenu();
        miMenu.findItem(R.id.nav_consulta_asignados).setVisible(false);
        miMenu.findItem(R.id.nav_atender).setVisible(false);
        miMenu.findItem(R.id.nav_reporte).setVisible(false);
        miMenu.findItem(R.id.nav_asignar).setVisible(false);
        miMenu.findItem(R.id.nav_consulta_todos).setVisible(false);
        //Colocas todos los items que deseas esconder
    }

    private void itemsSupervisor() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);// Colocas el id de tu NavigationView
        Menu miMenu= navigationView.getMenu();
        miMenu.findItem(R.id.nav_registrar).setVisible(false);
        miMenu.findItem(R.id.nav_estado).setVisible(false);
        miMenu.findItem(R.id.nav_asignar).setVisible(false);
        miMenu.findItem(R.id.nav_consulta_todos).setVisible(false);

        //Colocas todos los items que deseas esconder
    }

    private void itemsTecnico() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);// Colocas el id de tu NavigationView
        Menu miMenu= navigationView.getMenu();
        miMenu.findItem(R.id.nav_registrar).setVisible(false);
        miMenu.findItem(R.id.nav_estado).setVisible(false);
        miMenu.findItem(R.id.nav_consulta_asignados).setVisible(false);
        miMenu.findItem(R.id.nav_atender).setVisible(false);
        miMenu.findItem(R.id.nav_reporte).setVisible(false);

        //Colocas todos los items que deseas esconder
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
