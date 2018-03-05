package com.ejemplo.mydb03;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ejemplo.mydb03.utilidades.Utilidades;



public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public SQLiteDatabase myDB;


    public ConexionSQLiteHelper(Context context) {
        super(context, Utilidades.DBNAME, null, 1);
        myDB=getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)  {
            sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuarios");
        //onCreate(sqLiteDatabase);


    }

    public void openDB(){
        myDB=getWritableDatabase();

    }

    public void closeDB() {
        if (myDB != null && myDB.isOpen()) {
            myDB.close();

        }
    }

    public Cursor getAll(){

        String query="SELECT * FROM "+ Utilidades.TABLA;

        return myDB.rawQuery(query,null);

    }

    public long insert(String clave, String nombre, String sueldo){

        ContentValues cv = new ContentValues();
        cv.put(Utilidades.CLAVE,clave);
        cv.put(Utilidades.NOMBRE,nombre);
        cv.put(Utilidades.SUELDO,sueldo);

        return myDB.insert(Utilidades.TABLA,null,cv);
    }

    public String[][] consultar(String sql){// select * from usuario
        Cursor c = myDB.rawQuery(sql,null);
        String [][] elementos = new String [c.getCount()][c.getColumnCount()];
        if (c.moveToFirst()){
            int contador=0;
            do{
                elementos[contador][0]=c.getString(c.getColumnIndex("_id"));
                elementos[contador][1]=c.getString(c.getColumnIndex("clave"));
                elementos[contador][2]=c.getString(c.getColumnIndex("nombre"));
                elementos[contador][3]=c.getString(c.getColumnIndex("sueldo"));
                contador++;
            }while(c.moveToNext());
        }
        if(c!=null){c.close();}
        return elementos;
    }
}
