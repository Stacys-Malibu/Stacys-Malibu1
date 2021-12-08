package com.example.stacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stacy.Exam.MainQuiz;


public class Menu2Activity extends AppCompatActivity {
    private Button buttonParticipantes;
    private Button buttonExamen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        initViews();
        addEvents();


    }

    private void addEvents() {
        buttonParticipantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(Menu2Activity.this, perfil2Activity.class);
                startActivity(listIntent);
            }
        });
        buttonExamen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(Menu2Activity.this, MainQuiz.class);
                startActivity(listIntent);
            }
        });
    }

    private void initViews() {
        buttonParticipantes = (Button) findViewById(R.id.buttonPeril);
        buttonExamen =(Button) findViewById(R.id.examenUser);
    }
}
