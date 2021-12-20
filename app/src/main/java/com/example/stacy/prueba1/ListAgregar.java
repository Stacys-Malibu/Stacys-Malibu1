package com.example.stacy.prueba1;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stacy.prueba1.adapter.AgregarListViewAdapter;
import com.example.stacy.prueba1.model.Usuario;
import com.example.stacy.prueba1.utils.UsuariosUtils;

import com.google.gson.Gson;

import java.util.List;

public class ListAgregar extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listview;
    private Gson gson = new Gson();
    UsuariosBD BD;
    private Button btnVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagregar);
        initViews();
        BD =new UsuariosBD(this);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = BD.getdata();
                if(res.getCount()==0){
                    Toast.makeText(ListAgregar.this, "No Existe Entradas", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Apellido Paterno :"+res.getString(0)+"\n");
                    buffer.append("Apellido Materno :"+res.getString(1)+"\n");
                    buffer.append("Primer Nombre :"+res.getString(2)+"\n");
                    buffer.append("Segundo Nombre :"+res.getString(3)+"\n");
                    buffer.append("CI :"+res.getString(4)+"\n");
                    buffer.append("RDA :"+res.getString(5)+"\n");
                    buffer.append("Tipo Examen :"+res.getString(6)+"\n");
                    buffer.append("Carrera :"+res.getString(7)+"\n");
                    buffer.append("Area :"+res.getString(8)+"\n");
                    buffer.append("Departamento :"+res.getString(9)+"\n");
                    buffer.append("Categoria Postula :"+res.getString(10)+"\n");
                    buffer.append("Calificacion Final :"+res.getString(11)+"\n");
                    buffer.append("Password :"+res.getString(12)+"\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(ListAgregar.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }

    private void initViews() {
        btnVer = (Button) findViewById(R.id.ver1);
    }


}
