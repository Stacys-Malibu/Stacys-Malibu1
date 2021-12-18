package com.example.stacy.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuMaestroActivity extends AppCompatActivity {
    private Button buttonParticipantes;
    private Button buttonExamenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuadmi2_layout);
        initViews();
        addEvents();
    }

    private void addEvents() {
        buttonParticipantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(MenuMaestroActivity.this, ListAgregar2.class);
                startActivity(listIntent);
            }
        });
        buttonExamenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(MenuMaestroActivity.this, ListExamen2.class);
                startActivity(listIntent);
            }
        });
    }

    private void initViews() {
        buttonParticipantes = (Button) findViewById(R.id.buttonParticipantes1);
        buttonExamenes = (Button) findViewById(R.id.buttonExamenes1);
    }
}
