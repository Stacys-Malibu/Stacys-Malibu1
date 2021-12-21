package com.example.stacy;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.stacy.prueba1.adapter.AgregarListViewAdapter;
import com.example.stacy.prueba1.adapter.AgregarListViewAdapter3;
import com.example.stacy.prueba1.model.Examen;
import com.example.stacy.prueba1.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void AdapterItem(){
        final List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(new Usuario(0,"Malibu","Stacy","Matematica"));
        usuarioList.add(new Usuario(1,"M","Juanito","Matematica"));
        usuarioList.add(new Usuario(2,"M","Pedro","Matematica"));
        AgregarListViewAdapter agregarListViewAdapter= new AgregarListViewAdapter(null,usuarioList);

        assertEquals(usuarioList.get(2), agregarListViewAdapter.getItem(2));
    }

    @Test
    public void AdapterItemId(){
        final List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(new Usuario(0,"Malibu","Stacy","Matematica"));
        usuarioList.add(new Usuario(1,"M","Juanito","Matematica"));
        usuarioList.add(new Usuario(2,"M","Pedro","Matematica"));
        AgregarListViewAdapter agregarListViewAdapter= new AgregarListViewAdapter(null,usuarioList);

        assertEquals(usuarioList.get(2).getId(), agregarListViewAdapter.getItemId(2));
    }
    @Test
    public void UsuarioNombre(){

        Usuario usuario= new Usuario(0,"Malibu","Stacy","Fisica");

        assertEquals("Stacy", usuario.getNombre());
    }
    @Test
    public void UsuarioApellido(){

        Usuario usuario= new Usuario(0,"Malibu","Stacy","Fisica");

        assertEquals("Malibu", usuario.getApellido());
    }
    @Test
    public void UsuarioTipoExamen(){

        Usuario usuario= new Usuario(0,"Malibu","Stacy","Fisica");

        assertEquals("Fisica", usuario.getTipoE());
    }
    @Test
    public void UsuarioId(){

        Usuario usuario= new Usuario(3,"Malibu","Stacy","Fisica");

        assertEquals(3, usuario.getId());
    }
    @Test
    public void ExamenCategoria(){

        Examen examen= new Examen("Fisica","30",0);

        assertEquals("Fisica", examen.getCategoria());
    }

    @Test
    public void ExamenCantidad(){

        Examen examen= new Examen("Fisica","30",0);

        assertEquals("30", examen.getCantidad());
    }
    @Test
    public void ExamenId(){

        Examen examen= new Examen("Fisica","30",5);

        assertEquals(5, examen.getId());
    }
    @Test
    public void ExamenAdapter(){

        final List<Examen> exaList = new ArrayList<>();
        exaList.add(new Examen("A","3",0));
        exaList.add(new Examen("B","6",1));
        exaList.add(new Examen("C","0",2));
        AgregarListViewAdapter3 agregarListViewAdapter= new AgregarListViewAdapter3(null, exaList);

        assertEquals(exaList.get(2), agregarListViewAdapter.getItem(2));
    }

}