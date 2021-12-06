package com.example.stacy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AgregarActivity extends AppCompatActivity {
    EditText apellidoP , apellidoM, nombre1, nombre2,ci,rda, tipoExamen, area,carrera,
            departamento, categoríaPostula, calificacionFinal, password;
    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarusuario_layout);

        apellidoP=(EditText) findViewById(R.id.apellidoP);
        apellidoM=(EditText) findViewById(R.id.apellidoM);
        nombre1=(EditText) findViewById(R.id.nombre1);
        nombre2=(EditText) findViewById(R.id.nombre2);
        ci=(EditText) findViewById(R.id.ci);
        rda=(EditText) findViewById(R.id.rda);
        tipoExamen=(EditText) findViewById(R.id.tipoExamen);
        area=(EditText) findViewById(R.id.area);
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
                            String[] field = new String[13];
                            field[0] = "ApellidoPaterno";
                            field[1] = "ApellidoMaterno";
                            field[2] = "Nombre1";
                            field[3] = "Nombre2";
                            field[4] = "CI";
                            field[5] = "RDA";
                            field[6] = "TipoExamen";
                            field[7] = "Area";
                            field[8] = "Carrera";
                            field[9] = "Departamento";
                            field[10] = "CategoriaPostula";
                            field[11] = "CalificacionFinal";
                            field[12] = "Password";
                            //Creating array for data
                            String[] data = new String[13];
                            data[0] = ApellidoPaterno;
                            data[1] = ApellidoMaterno;
                            data[2] = Nombre1;
                            data[3] = Nombre2;
                            data[4] = CI;
                            data[5] = RDA;
                            data[6] = TipoExamen;
                            data[7] = Area;
                            data[8] = Carrera;
                            data[9] = Departamento;
                            data[10] = CategoriaPostula;
                            data[11] = CalificacionFinal;
                            data[12] = Password;
                            PutData putData = new PutData("http://192.168.40.1/Login/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success")){
                                        Intent intent =new Intent(getApplicationContext(), MenuAdmiActivity.class);
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


            }
        });



    }
}