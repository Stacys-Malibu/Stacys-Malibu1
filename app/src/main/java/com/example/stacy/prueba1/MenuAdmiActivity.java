package com.example.stacy.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MenuAdmiActivity extends AppCompatActivity {
    private Button buttonParticipantes;
    private Button buttonExamenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuadmi_layout);
        initViews();
        addEvents();
    }

    private void addEvents() {
        buttonParticipantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(MenuAdmiActivity.this, ListAgregar.class);
                startActivity(listIntent);
            }
        });
        buttonExamenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(MenuAdmiActivity.this, ListExamen.class);
                startActivity(listIntent);
            }
        });
    }

    private void initViews() {
        buttonParticipantes = (Button) findViewById(R.id.buttonParticipantes);
        buttonExamenes = (Button) findViewById(R.id.buttonExamenes);
    }

}
