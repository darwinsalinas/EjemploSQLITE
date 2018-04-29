package com.example.miguel.ejemplosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import SQLITE.crudsqlite;

public class ActivityLista extends AppCompatActivity
{
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        listview=(ListView)findViewById(R.id.lista_usuarios);
        crudsqlite crud=new crudsqlite(this);
        //crud.consultar();
        List<String> listacliente=crud.consultarnombres();
        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listacliente);
        listview.setAdapter(adapter);

       // Toast.makeText(this,listacliente.size(),Toast.LENGTH_SHORT).show();
    }
}
