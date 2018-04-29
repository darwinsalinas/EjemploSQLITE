package com.example.miguel.ejemplosqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import SQLITE.AdminSQLiteOpenHelper;
import SQLITE.crudsqlite;
import SQLITE.usuario;

public class MainActivity extends AppCompatActivity
{

    EditText etnombre;
    EditText etcontrasenya;
    EditText etlista;
    crudsqlite crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         etnombre=(EditText)findViewById(R.id.etnombre);
        etcontrasenya=(EditText)findViewById(R.id.etcontrasenya);
      //  etlista=(EditText) findViewById(R.id.etlista);
        crud=new crudsqlite(this);
    }

    public void btguardar_onclick(View view)
    {

        crud.insertar(etnombre.getText().toString(),etcontrasenya.getText().toString());
       // ArrayList<usuario> lista=crud.consultar();

        Toast.makeText(this,"Registro Guardado",Toast.LENGTH_SHORT).show();




    }

    public void btmostrarusuarios_onclick(View view)
    {
        Intent intent=new Intent(this,ActivityLista.class);
        startActivity(intent);
    }
}
