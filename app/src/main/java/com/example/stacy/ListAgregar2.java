package com.example.stacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.stacy.adapter.AgregarListViewAdapter2;
import com.example.stacy.model.Usuario;
import com.example.stacy.utils.UsuariosUtils;
import com.google.gson.Gson;

import java.util.List;

public class ListAgregar2 extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listview;
    private Button particpantes;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagregar2);
        initViews();
        particpantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListAgregar2.this, AgregarActivity.class);
                startActivity(intent);

            }
        });

        final List<Usuario> usuarioList2 = UsuariosUtils.getUsuarios();
        AgregarListViewAdapter2 adapter = new AgregarListViewAdapter2(this, usuarioList2);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuario = usuarioList2.get(position);
                Intent intent = new Intent(ListAgregar2.this, UsuarioDetailsActivity.class);
                intent.putExtra(Constants.USUARIO_SELECTED, gson.toJson(usuario));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);

    }

    private void initViews() {
        listview = findViewById(R.id.listViewMyPokemons2);
        particpantes=(Button) findViewById(R.id.buttonAP2);
    }
}
