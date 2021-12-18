package com.example.stacy.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.stacy.prueba1.adapter.AgregarListViewAdapter3;
import com.example.stacy.prueba1.model.Examen;
import com.example.stacy.prueba1.utils.ExamenUtils;
import com.google.gson.Gson;

import java.util.List;

public class ListExamen extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listview;

    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaexamen);
        initViews();

        final List<Examen> examenList = ExamenUtils.getExamenes();
        AgregarListViewAdapter3 adapter = new AgregarListViewAdapter3(ListExamen.this, examenList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Examen examen = examenList.get(position);
                Intent intent = new Intent(ListExamen.this, UsuarioDetailsActivity.class);
                intent.putExtra(Constants.USUARIO_SELECTED, gson.toJson(examen));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);

    }

    private void initViews() {
        listview = findViewById(R.id.listViewMyPokemons3);
    }
}
