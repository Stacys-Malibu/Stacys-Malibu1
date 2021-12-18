package com.example.stacy.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.stacy.prueba1.adapter.AgregarListViewAdapter4;
import com.example.stacy.prueba1.model.Examen;
import com.example.stacy.prueba1.utils.ExamenUtils;
import com.google.gson.Gson;

import java.util.List;

public class ListExamen2 extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listview;
    private Button examen;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaexamen2);
        initViews();
        examen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListExamen2.this, AgregarExamen.class);
                startActivity(intent);

            }
        });

        final List<Examen> examenList2 = ExamenUtils.getExamenes();
        AgregarListViewAdapter4 adapter = new AgregarListViewAdapter4(ListExamen2.this,examenList2);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Examen examen = examenList2.get(position);
                Intent intent = new Intent(ListExamen2.this, UsuarioDetailsActivity.class);
                intent.putExtra(Constants.USUARIO_SELECTED, gson.toJson(examen));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);

    }

    private void initViews() {
        listview = findViewById(R.id.listViewMyPokemons4);
        examen =(Button) findViewById(R.id.buttonAP4);
    }
}
