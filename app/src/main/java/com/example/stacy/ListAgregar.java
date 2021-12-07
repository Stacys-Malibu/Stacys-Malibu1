package com.example.stacy;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.stacy.adapter.AgregarListViewAdapter;
import com.example.stacy.model.Usuario;
import com.example.stacy.utils.UsuariosUtils;
import com.google.gson.Gson;

import java.util.List;

public class ListAgregar extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listview;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagregar);
        initViews();

        final List<Usuario> usuarioList = UsuariosUtils.getUsuarios();
        AgregarListViewAdapter adapter = new AgregarListViewAdapter(this, usuarioList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuario = usuarioList.get(position);
                Intent intent = new Intent(ListAgregar.this, UsuarioDetailsActivity.class);
                intent.putExtra(Constants.USUARIO_SELECTED, gson.toJson(usuario));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);
    }

    private void initViews() {
        listview = findViewById(R.id.listViewMyPokemons);
    }


}
