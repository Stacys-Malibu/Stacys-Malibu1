package com.example.stacy.prueba1.utils;

import com.example.stacy.prueba1.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosUtils {

    public static List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(0,"Malibu","Stacy","Matematica"));
            usuarios.add(new Usuario(1,"M","Juanito","Matematica"));

        return usuarios;
    }
}
