package com.example.stacy.utils;



import com.example.stacy.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosUtils {
    public static List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Malibu","Stacy","Matematica",1));
            usuarios.add(new Usuario("M","Juanito","Matematica",2));

        return usuarios;
    }
}
