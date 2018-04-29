package SQLITE;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class crudsqlite
{
    AdminSQLiteOpenHelper admin;
    Context context;
    public  crudsqlite(Context c)
    {
        context=c;
        admin= new AdminSQLiteOpenHelper(c,"administracion", null, 1);


    }
    public  void insertar(String nomb,String contr)
    {
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put("nombre",nomb);
        valores.put("contrasenya",contr);
        Toast.makeText(context,nomb+"    "+contr,Toast.LENGTH_SHORT).show();

        bd.insert("usuario",null,valores);
        bd.close();
    }
    public  ArrayList<usuario> consultar()
    {
        ArrayList<usuario> list=new ArrayList<usuario>();


        SQLiteDatabase bd = admin.getWritableDatabase();
        String[] resultColumns = new String[] {"nombre", "contrasenya" };
        Cursor filas = bd.query(true,"usuario",resultColumns,null,null,null,null,null,null);
       // Cursor filas = bd.rawQuery("select * from usuario" , null);
        if(filas==null)
            Toast.makeText(context,"No hay registros",Toast.LENGTH_SHORT).show();

        //Toast.makeText(context,filas.getCount(),Toast.LENGTH_SHORT).show();

        if(filas.moveToFirst())
        {
          do
            {
              usuario u=new usuario();
             // u.setDni(filas.getInt(0));
               // Log.e("id",String.valueOf( u.getDni()));
              u.setNombre(filas.getString(0));
                Log.e("nombre",u.getNombre());
              u.setContrasenya(filas.getString(1));
               Log.e("contrasenya",u.getContrasenya());
                list.add(u);
            }while (filas.moveToNext());
        }
       // Toast.makeText(context,list.size(),Toast.LENGTH_SHORT).show();


     return  list;

    }

    public  ArrayList<String> consultarnombres()
    {
        String[] resultColumns = new String[] {"nombre"};
        SQLiteDatabase bd=admin.getWritableDatabase();
        Cursor filas = bd.query(true,"usuario",resultColumns,null,null,null,null,null,null);
        //Cursor filas=bd.rawQuery("select nombre from usuario",null);
        ArrayList<String> lista=new ArrayList<String>();

        // Toast.makeText(context,filas.getCount(),Toast.LENGTH_SHORT).show();
        if(filas.moveToFirst())
        {
            do {
                String nombre=filas.getString(0);
                Log.e("nombre",nombre);
                lista.add(nombre);

            }while (filas.moveToNext());
        }


        return  lista;

    }
}
