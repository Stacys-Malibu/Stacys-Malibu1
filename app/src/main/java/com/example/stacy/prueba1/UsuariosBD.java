package com.example.stacy.prueba1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UsuariosBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="usuarios.bd";


    public UsuariosBD(Context context) {
        super(context, "usuarios.bd", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table usuarios ( APELLIDOP TEXT, APELLIDOM TEXT, NOMBRE1 TEXT, NOMBRE2 TEXT,CI TEXT PRIMARY KEY, RDA TEXT,TIPOE TEXT, CARRERA TEXT, AREA TEXT, DEPARTAMENTO TEXT, CATEGORIAPOSTULA TEXT, CALIFICACIONFINAL TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS usuarios");

    }
    public Boolean insertarDatos( String apellidoP, String apellidoM, String nombre1, String nombre2, String ci, String rda,String tipoE, String carrera, String area, String departamento,String categoriaPostula, String calificacionFinal,String password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("apellidoP",apellidoP);
        contentValues.put("apellidoM",apellidoM);
        contentValues.put("nombre1",nombre1);
        contentValues.put("nombre2",nombre2);
        contentValues.put("ci",ci);
        contentValues.put("rda",rda);
        contentValues.put("tipoE",tipoE);
        contentValues.put("carrera",carrera);
        contentValues.put("area",area);
        contentValues.put("departamento",departamento);
        contentValues.put("categoriaPostula",categoriaPostula);
        contentValues.put("calificacionFinal",calificacionFinal);
        contentValues.put("password",password);
        long result =MyDB.insert("usuarios",null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean checkUsuario(String ci){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("SELECT * FROM usuarios WHERE ci = ? ",new String[]{ci});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

}
