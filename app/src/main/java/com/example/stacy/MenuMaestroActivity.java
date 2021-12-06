package com.example.stacy;

import android.app.Activity;
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
        setContentView(R.layout.menumaestro_layout);
        initViews();
        addEvents();

    }

    private void addEvents() {
        buttonParticipantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(MenuMaestroActivity.this, AgregarActivity.class);
                startActivity(listIntent);
            }
        });
        buttonExamenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(MenuMaestroActivity.this, AgregarActivity.class);
                startActivity(listIntent);
            }
        });
    }

    private void initViews() {
        buttonParticipantes = (Button) findViewById(R.id.botonParticipantes);
        buttonExamenes = (Button) findViewById(R.id.botonExamenes);
    }
}
