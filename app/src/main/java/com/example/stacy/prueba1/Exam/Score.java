package com.example.stacy.prueba1.Exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stacy.prueba1.R;

public class Score extends AppCompatActivity {
    Intent i, recibe;
    Bundle bolsa;
    int calificacion = 0;
    Button reg;
    TextView txt;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.score);
        reg = (Button) findViewById(R.id.regresar);
        txt = (TextView) findViewById(R.id.score);
        i = new Intent(Score.this, MainQuiz.class);
        try {
            recibe = getIntent();
            bolsa = recibe.getExtras();
            calificacion = bolsa.getInt("calificacion");
            txt.setText("Score:" + calificacion);

        } catch (Exception e) {
            Toast.makeText(this, "Error al recibir datos", Toast.LENGTH_SHORT).show();
        }
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
                finish();
            }
        });
    }
}
