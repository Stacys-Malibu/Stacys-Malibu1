package com.example.stacy.prueba1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class AgregarExamen extends AppCompatActivity {
    EditText categoriA, preguntA, respuesta_C,incorrecta_1, incorrecta_2 ;
    Button btnAgregar, btnEliminar, btnEditar, btnVer;
    ExamenBD BD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarexamen_layout);
        //btnAgregar=(Button) findViewById(R.id.anadir);
        //btnAgregar.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View view) {
        //   Intent intent =new Intent(getApplicationContext(), MenuMaestroActivity.class);
        //  startActivity(intent);

        categoriA=(EditText) findViewById(R.id.categoriaExamen);
        preguntA=(EditText) findViewById(R.id.preguntaE);
        respuesta_C=(EditText) findViewById(R.id.RespuestaC);
        incorrecta_1=(EditText) findViewById(R.id.opcionb);
        incorrecta_2=(EditText) findViewById(R.id.opcionc);

        btnAgregar=(Button) findViewById(R.id.anadirE);
        btnEditar=(Button) findViewById(R.id.editarE);
        btnEliminar=(Button) findViewById(R.id.eliminarE);
        btnVer=(Button) findViewById(R.id.verExamen);
        BD =new ExamenBD(this);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String categoria= categoriA.getText().toString();
                String pregunta=preguntA.getText().toString();
                String respuestaC=respuesta_C.getText().toString();
                String incorrecta1=incorrecta_1.getText().toString();
                String incorrecta2=incorrecta_2.getText().toString();
                if(categoria.equals("")||pregunta.equals("")||respuestaC.equals("")||incorrecta1.equals("")||
                        incorrecta2.equals("")){
                    Toast.makeText(AgregarExamen.this,"Ingrese todos los datos",Toast.LENGTH_SHORT).show();

                }else{
                    Boolean checkUser=BD.checkUsuario(categoria);
                    if(checkUser==false){
                        Boolean insert =BD.insertarDatos(categoria,pregunta,respuestaC,incorrecta1,incorrecta2);
                        if(insert==true){
                            Toast.makeText(AgregarExamen.this,"Registro exitoso",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AgregarExamen.this,"No se inserto ",Toast.LENGTH_SHORT).show();
                        }
                    }
                }


            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoria= categoriA.getText().toString();
                Boolean checkudeletedata = BD.deletedata(categoria);
                if(checkudeletedata==true)
                    Toast.makeText(AgregarExamen.this, "Entrada Eliminada", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AgregarExamen.this, "Entrada No Eliminada", Toast.LENGTH_SHORT).show();

            }
        });
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoria= categoriA.getText().toString();
                String pregunta=preguntA.getText().toString();
                String respuestaC=respuesta_C.getText().toString();
                String incorrecta1=incorrecta_1.getText().toString();
                String incorrecta2=incorrecta_2.getText().toString();
                Boolean checkupdatedata = BD.updateuserdata(categoria,pregunta,respuestaC,incorrecta1,incorrecta2);
                if(checkupdatedata==true)
                    Toast.makeText(AgregarExamen.this, "Entrada Editada", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AgregarExamen.this, "Nueva Entrada no editada", Toast.LENGTH_SHORT).show();
            }
        });
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = BD.getdata();
                if(res.getCount()==0){
                    Toast.makeText(AgregarExamen.this, "No Existe Entradas", Toast.LENGTH_SHORT).show();
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

                AlertDialog.Builder builder = new AlertDialog.Builder(AgregarExamen.this);
                builder.setCancelable(true);
                builder.setTitle("Examenes Registrados");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}
