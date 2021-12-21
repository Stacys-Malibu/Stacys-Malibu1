package com.example.stacy.prueba1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stacy.prueba1.Exam.MainQuiz;


public class MenuActivity extends AppCompatActivity {
    private Button buttonParticipantes;
    private Button buttonExamen;
    UsuariosBD BD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        initViews();
        addEvents();


    }

    private void addEvents() {
        BD =new UsuariosBD(this);
        buttonParticipantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = BD.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MenuActivity.this, "No Existe Entradas", Toast.LENGTH_SHORT).show();
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

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Perfil");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        buttonExamen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(MenuActivity.this, MainQuiz.class);
                startActivity(listIntent);
            }
        });
    }

    private void initViews() {
        buttonParticipantes = (Button) findViewById(R.id.buttonPeril);
        buttonExamen =(Button) findViewById(R.id.examenUser);
    }
}
