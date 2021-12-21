package com.example.stacy.prueba1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ExamenBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="examenes.bd";


    public ExamenBD(Context context) {
        super(context, "examenes.bd", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table examenes ( CATEGORIAEXA TEXT PRIMARY KEY, PREGUNTA TEXT,RESPUESTACORR TEXT, INCORRECTA1 TEXT, INCORRECTA2 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS examenes");

    }
    public Boolean insertarDatos( String categoriaExa,String pregunta, String respuestaCorr, String incorrecta1, String incorrecta2){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("categoriaExa",categoriaExa);
        contentValues.put("pregunta",pregunta);
        contentValues.put("respuestaCorr",respuestaCorr);
        contentValues.put("incorrecta1",incorrecta1);
        contentValues.put("incorrecta2",incorrecta2);
        long result =MyDB.insert("examenes",null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean checkUsuario(String categoriaExa){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("SELECT * FROM examenes WHERE categoriaExa = ? ",new String[]{categoriaExa});
        if((cursor.getCount()>0)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean updateuserdata(String categoriaExa,String pregunta, String respuestaCorr, String incorrecta1, String incorrecta2) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pregunta",pregunta);
        contentValues.put("respuestaCorr",respuestaCorr);
        contentValues.put("incorrecta1",incorrecta1);
        contentValues.put("incorrecta2",incorrecta2);
        Cursor cursor = DB.rawQuery("Select * from examenes where categoriaExa = ?", new String[]{categoriaExa});
        if (cursor.getCount() > 0) {
            long result = DB.update("examenes", contentValues, "categoriaExa=?", new String[]{categoriaExa});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}


    public Boolean deletedata (String categoriaExa)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from examenes where categoriaExa = ?", new String[]{categoriaExa});
        if (cursor.getCount() > 0) {
            long result = DB.delete("examenes", "categoriaExa=?", new String[]{categoriaExa});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from examenes", null);
        return cursor;

    }

}
