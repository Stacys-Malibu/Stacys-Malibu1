package com.example.stacy.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    public static String LOG = MainActivity.class.getName();
    private EditText usuario, password;
    private Button buttonStart;
    UsuariosBD BD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(LOG, "onCreate");
        initViews();
        addEvents();

    }
    private void initViews() {
        buttonStart = (Button) findViewById(R.id.BotonIngresar);
        usuario = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPassword);
    }

    private void addEvents(){
        BD = new UsuariosBD(this);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuariO = usuario.getText().toString();
                String pass=password.getText().toString();
                if(usuariO.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity.this,"Llene los campos",Toast.LENGTH_SHORT).show();
                }else if(usuariO.equals("123")||pass.equals("123")) {
                    Intent intent = new Intent(getApplicationContext(),MenuMaestroActivity.class);
                    startActivity(intent);
                }else{
                    Boolean checkUser= BD.checkUsuario(usuariO);
                    if(checkUser== true){
                        Toast.makeText(MainActivity.this,"Login exitoso",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MenuMaestroActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"fallo",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }


        }