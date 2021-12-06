package com.example.stacy;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MenuAdmiActivity extends AppCompatActivity {
    private Button buttonParticipantes;
    private Button buttonExamen;



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
                Intent listIntent = new Intent(MenuAdmiActivity.this, ListaParticipantes.class);
                startActivity(listIntent);
            }
        });
        buttonExamen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(MenuAdmiActivity.this, ListaParticipantes.class);
                startActivity(listIntent);
            }
        });
    }

    private void initViews() {
        buttonParticipantes = (Button) findViewById(R.id.participantes);
        buttonExamen = (Button) findViewById(R.id.examenes);
    }
}