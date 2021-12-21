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

import com.example.stacy.prueba1.R;

public class AgregarActivity extends AppCompatActivity {
    EditText apellidop , apellidom, nombre_1, nombre_2,cI,rdA, tipoexamen, areA,carrerA,
            departamentO, categoríapostula, calificacionfinal, passworD;
    Button btnAgregar, btnEliminar, btnEditar, btnVer;
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
                btnEditar=(Button) findViewById(R.id.editar);
                btnEliminar=(Button) findViewById(R.id.eliminar);
                btnVer=(Button) findViewById(R.id.ver);
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
                            Boolean checkUser=BD.checkUsuario(ci, password);
                            if(checkUser==false){
                                Boolean insert =BD.insertarDatos(apellidoP,apellidoM,nombre1,nombre2,ci,rda,tipoExamen,carrera,area,
                                        departamento,categoríaPostula,calificacionFinal,password);
                                if(insert==true){
                                    Toast.makeText(AgregarActivity.this,"Registro exitoso",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(AgregarActivity.this,"No se inserto xd",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }


                    }
                });
                btnEliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ci= cI.getText().toString();
                        Boolean checkudeletedata = BD.deletedata(ci);
                        if(checkudeletedata==true)
                            Toast.makeText(AgregarActivity.this, "Entrada Eliminada", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(AgregarActivity.this, "Entrada No Eliminada", Toast.LENGTH_SHORT).show();

                    }
                });
                btnEditar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
                        Boolean checkupdatedata = BD.updateuserdata(apellidoP,apellidoM,nombre1,nombre2,ci,rda,tipoExamen,carrera,area,
                                departamento,categoríaPostula,calificacionFinal,password);
                        if(checkupdatedata==true)
                            Toast.makeText(AgregarActivity.this, "Entrada Editada", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(AgregarActivity.this, "Nueva entrada no editada", Toast.LENGTH_SHORT).show();
                    }
                });
                btnVer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = BD.getdata();
                        if(res.getCount()==0){
                            Toast.makeText(AgregarActivity.this, "No Existe Entradas", Toast.LENGTH_SHORT).show();
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

                        AlertDialog.Builder builder = new AlertDialog.Builder(AgregarActivity.this);
                        builder.setCancelable(true);
                        builder.setTitle("User Entries");
                        builder.setMessage(buffer.toString());
                        builder.show();
                    }
                });
    }

}

