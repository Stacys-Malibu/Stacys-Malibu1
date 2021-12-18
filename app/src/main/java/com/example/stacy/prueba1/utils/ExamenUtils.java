package com.example.stacy.prueba1.utils;

import com.example.stacy.prueba1.model.Examen;

import java.util.ArrayList;
import java.util.List;

public class ExamenUtils {
    public static List<Examen> getExamenes() {
        List<Examen> examen = new ArrayList<>();
        examen.add(new Examen("PTR-A","2",1));
        examen.add(new Examen("PTR-B","1",2));
        return examen;
    }
}
