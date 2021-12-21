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


import com.example.stacy.prueba1.adapter.AgregarListViewAdapter3;
import com.example.stacy.prueba1.model.Examen;
import com.example.stacy.prueba1.utils.ExamenUtils;
import com.google.gson.Gson;

import java.util.List;

public class ListExamen extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listview;
    ExamenBD BD;
    private Button btnVer;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaexamen);
        initViews();

        BD =new ExamenBD(this);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = BD.getdata();
                if(res.getCount()==0){
                    Toast.makeText(ListExamen.this, "No Existe Entradas", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Categoria Examen :"+res.getString(0)+"\n");
                    buffer.append("Pregunta :"+res.getString(1)+"\n");
                    buffer.append("Respuesta Correcta :"+res.getString(2)+"\n");
                    buffer.append("Respuesta Incorrecta 1 :"+res.getString(3)+"\n");
                    buffer.append("Respuesta Incorrecta 2 :"+res.getString(4)+"\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(ListExamen.this);
                builder.setCancelable(true);
                builder.setTitle("Examenes Registrados");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }

    private void initViews() {
        btnVer = (Button) findViewById(R.id.ver2);
    }
}
