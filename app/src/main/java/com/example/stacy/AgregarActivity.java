package com.example.stacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarActivity extends AppCompatActivity {
    EditText apellidoP , apellidoM, nombre1, nombre2,ci,rda, tipoExamen, area,carrera,
            departamento, categoríaPostula, calificacionFinal, password;
    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarusuario_layout);
        btnAgregar=(Button) findViewById(R.id.anadir);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), MenuMaestroActivity.class);
                startActivity(intent);
                /*apellidoP=(EditText) findViewById(R.id.apellidoP);
                apellidoM=(EditText) findViewById(R.id.apellidoM);
                nombre1=(EditText) findViewById(R.id.nombre1);
                nombre2=(EditText) findViewById(R.id.nombre2);
                ci=(EditText) findViewById(R.id.ci);
                rda=(EditText) findViewById(R.id.rda);
                tipoExamen=(EditText) findViewById(R.id.tipoExamen);
                carrera=(EditText) findViewById(R.id.carrera);
                departamento=(EditText) findViewById(R.id.departamento);
                categoríaPostula=(EditText) findViewById(R.id.categoriaPostula);
                calificacionFinal=(EditText) findViewById(R.id.calificacionFinal);
                password=(EditText) findViewById(R.id.codigoUser) ;
                btnAgregar=(Button) findViewById(R.id.anadir);
                btnAgregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String ApellidoPaterno,ApellidoMaterno, Nombre1, Nombre2, CI,
                                RDA, TipoExamen, Area, Carrera, Departamento, CategoriaPostula, CalificacionFinal ,Password;
                        ApellidoPaterno= String.valueOf(apellidoP.getText());
                        ApellidoMaterno= String.valueOf(apellidoM.getText());
                        Nombre1= String.valueOf(nombre1.getText());
                        Nombre2= String.valueOf(nombre2.getText());
                        CI= String.valueOf(ci.getText());
                        RDA= String.valueOf(rda.getText());
                        TipoExamen= String.valueOf(tipoExamen.getText());
                        Area= String.valueOf(area.getText());
                        Carrera= String.valueOf(carrera.getText());
                        Departamento= String.valueOf(departamento.getText());
                        CategoriaPostula= String.valueOf(categoríaPostula.getText());
                        CalificacionFinal= String.valueOf(calificacionFinal.getText());
                        Password= String.valueOf(password.getText());

                        if(ApellidoPaterno.equals("")&& ApellidoMaterno.equals("")&&Nombre1.equals("")
                                && Nombre2.equals("")&&CI.equals("")&&RDA.equals("")&&TipoExamen.equals("")&&Area.equals("")&&
                                Carrera.equals("")&&Departamento.equals("")&&CategoriaPostula.equals("")&&CalificacionFinal.equals("")&&Password.equals("")){
                            //Start ProgressBar first (Set visibility VISIBLE)
                            Handler handler = new Handler();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    String[] field = new String[12];
                                    field[0] = "ApellidoPaterno";
                                    field[1] = "ApellidoMaterno";
                                    field[2] = "Nombre1";
                                    field[3] = "Nombre2";
                                    field[4] = "CI";
                                    field[5] = "RDA";
                                    field[6] = "TipoExamen";
                                    field[7] = "Carrera";
                                    field[8] = "Departamento";
                                    field[9] = "CategoriaPostula";
                                    field[10] = "CalificacionFinal";
                                    field[11] = "Password";
                                    //Creating array for data
                                    String[] data = new String[12];
                                    data[0] = ApellidoPaterno;
                                    data[1] = ApellidoMaterno;
                                    data[2] = Nombre1;
                                    data[3] = Nombre2;
                                    data[4] = CI;
                                    data[5] = RDA;
                                    data[6] = TipoExamen;
                                    data[7] = Carrera;
                                    data[8] = Departamento;
                                    data[9] = CategoriaPostula;
                                    data[10] = CalificacionFinal;
                                    data[11] = Password;
                                    PutData putData = new PutData("http://192.168.0.5/Login/signup.php", "POST", field, data);
                                    if (putData.startPut()) {
                                        if (putData.onComplete()) {
                                            String result = putData.getResult();
                                            if(result.equals("Sign Up Success")){
                                                Intent intent =new Intent(getApplicationContext(), MenuMaestroActivity.class);
                                                startActivity(intent);
                                                finish();

                                            }else{
                                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                    //End Write and Read data with URL
                                }
                            });
                        }else{
                            Toast.makeText(getApplicationContext(),"All files required",Toast.LENGTH_SHORT).show();
                        }

**/
                    }
                });

            }
    }

