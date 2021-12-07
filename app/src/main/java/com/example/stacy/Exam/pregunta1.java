package com.example.stacy.Exam;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.stacy.R;


public class pregunta1 extends Activity implements View.OnClickListener {
    Button b,c,d,sig;
    TextView a;
    int calificacion=0;
    Intent i;
    @Override
    protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pregunta1);
            i=new Intent(pregunta1.this, Pregunta2.class);
            a= (TextView) findViewById(R.id.a1);
            b=(Button) findViewById(R.id.b1);
            c=(Button) findViewById(R.id.c1);
            d= (Button) findViewById(R.id.d1);
            sig=(Button) findViewById(R.id.sig);
            d.setOnClickListener(this);
            b.setOnClickListener(this);
            c.setOnClickListener(this);
            sig.setOnClickListener(this);
            sig.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d1://respuesta correcta
                calificacion+=10;
                deshabilitar();

                break;
            case R.id.b1:
                calificacion+=0;
                deshabilitar();
                break;
            case R.id.c1:
                calificacion+=0;
                deshabilitar();
                break;
            case R.id.sig:
                startActivity(i);
                break;
            default:
                break;
        }
        i.putExtra("calificacion", calificacion);
    }

    public void deshabilitar(){
        d.setBackgroundColor(Color.GREEN);
        b.setBackgroundColor(Color.RED);
        c.setBackgroundColor(Color.RED);
        d.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        sig.setEnabled(true);
    }
}
