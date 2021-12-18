package com.example.stacy.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stacy.prueba1.R;

public class AgregarActivity extends AppCompatActivity {
    EditText apellidop , apellidom, nombre_1, nombre_2,cI,rdA, tipoexamen, areA,carrerA,
            departamentO, categoríapostula, calificacionfinal, passworD;
    Button btnAgregar;
    UsuariosBD BD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarusuario_layout);
        //btnAgregar=(Button) findViewById(R.id.anadir);
        //btnAgregar.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
             //   Intent intent =new Intent(getApplicationContext(), MenuMaestroActivity.class);
              //  startActivity(intent);

                apellidop=(EditText) findViewById(R.id.apellidoP);
                apellidom=(EditText) findViewById(R.id.apellidoM);
                nombre_1=(EditText) findViewById(R.id.nombre1);
                nombre_2=(EditText) findViewById(R.id.nombre2);
                cI=(EditText) findViewById(R.id.ci);
                rdA=(EditText) findViewById(R.id.rda);
                tipoexamen=(EditText) findViewById(R.id.tipoExamen);
                carrerA=(EditText) findViewById(R.id.carrera);
                areA=(EditText) findViewById(R.id.area) ;
                departamentO=(EditText) findViewById(R.id.departamento);
                categoríapostula=(EditText) findViewById(R.id.categoriaPostula);
                calificacionfinal=(EditText) findViewById(R.id.calificacionFinal);
                passworD=(EditText) findViewById(R.id.codigoUser) ;
                btnAgregar=(Button) findViewById(R.id.anadir);
                BD =new UsuariosBD(this);

                btnAgregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String apellidoP= apellidop.getText().toString();
                        String apellidoM=apellidom.getText().toString();
                        String nombre1=nombre_1.getText().toString();
                        String nombre2=nombre_2.getText().toString();
                        String ci=cI.getText().toString();
                        String rda=rdA.getText().toString();
                        String tipoExamen=tipoexamen.getText().toString();
                        String carrera=carrerA.getText().toString();
                        String area= areA.getText().toString();
                        String departamento=departamentO.getText().toString();
                        String categoríaPostula=categoríapostula.getText().toString();
                        String calificacionFinal=calificacionfinal.getText().toString();
                        String password= passworD.getText().toString();
                        if(apellidoM.equals("")||apellidoP.equals("")||nombre1.equals("")||nombre2.equals("")||
                        ci.equals("")||rda.equals("")||tipoExamen.equals("")||carrera.equals("")||area.equals("")||departamento.equals("")||
                        categoríaPostula.equals("")||calificacionFinal.equals("")||password.equals("")){
                            Toast.makeText(AgregarActivity.this,"Ingrese todos los datos",Toast.LENGTH_SHORT).show();

                        }else{
                            Boolean checkUser=BD.checkUsuario(ci);
                            if(checkUser==false){
                                Boolean insert =BD.insertarDatos(apellidoP,apellidoM,nombre1,nombre2,ci,rda,tipoExamen,carrera,area,
                                        departamento,categoríaPostula,calificacionFinal,password);
                                if(insert==true){
                                    Toast.makeText(AgregarActivity.this,"Registro exitoso",Toast.LENGTH_SHORT).show();
                                    Intent listIntent = new Intent(AgregarActivity.this, MenuMaestroActivity.class);
                                    startActivity(listIntent);
                                }else{
                                    Toast.makeText(AgregarActivity.this,"No se inserto xd",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }


                    }
                });

            //}
    }

}

