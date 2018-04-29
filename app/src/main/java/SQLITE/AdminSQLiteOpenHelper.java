package SQLITE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    Context c;
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        c=context;

    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table usuario(_id  INTEGER PRIMARY KEY, nombre TEXT,  contrasenya TEXT)");
        Toast.makeText(c,"Creando base de datos ".toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists usuario");
        db.execSQL("create table usuario(_id integer primary key, nombre text, contrasenya text)");


    }
}
