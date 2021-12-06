package com.example.stacy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ListaParticipantes extends AppCompatActivity {
    private ListView taskListView;
    private Button addButton;
    private Button deleteButton;
    private Button searchButton;
    private EditText wordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_participantes);
    }
}