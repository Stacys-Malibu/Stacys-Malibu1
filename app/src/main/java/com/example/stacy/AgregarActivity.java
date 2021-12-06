package com.example.stacy;

import android.app.ProgressDialog;
import android.os.Bundle;
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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AgregarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText apellidoP , apellidoM, nombre1, nombre2,ci,rda,codigoUser, tipoExamen, area,carrera,
    departamento, categoríaPostula, calificacionFinal;
    Button btnAgregar;
    ProgressDialog progreso;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarusuario_layout);
        codigoUser=(EditText) findViewById(R.id.codigoUser);
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
        btnAgregar=(Button) findViewById(R.id.anadir);
        requestQueue= Volley.newRequestQueue(getApplicationContext());

        /*btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio();
            }
        });*/
    }
    /*private void ejecutarServicio(){
        String URL="http://192.168.0.5:80/MEyD/insertar.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"OPERACION EXITOSA",Toast.LENGTH_SHORT).show();
            }
    }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros= new HashMap<String, String>();
                parametros.put("codigoUser",codigoUser.getText().toString());
                parametros.put("apellidoP",apellidoP.getText().toString());
                parametros.put("apellidoM",apellidoM.getText().toString());
                parametros.put("nombre1",nombre1.getText().toString());
                parametros.put("nombre2",nombre2.getText().toString());
                parametros.put("ci",ci.getText().toString());
                parametros.put("rda",rda.getText().toString());
                parametros.put("tipoExamen",tipoExamen.getText().toString());
                parametros.put("area",area.getText().toString());
                parametros.put("carrera",carrera.getText().toString());
                parametros.put("departamento",departamento.getText().toString());
                parametros.put("categoriaPostula",categoríaPostula.getText().toString());
                parametros.put("calificacionFinal",calificacionFinal.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }*/

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}