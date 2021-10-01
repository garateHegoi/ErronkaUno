package com.example.erronkauno;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;


import android.os.Bundle;
import android.util.Log;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;


import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lv;
    int n = 0;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)  findViewById(R.id.nav_search);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        lv = (ListView) findViewById(R.id.tv_emptyTextView);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,aldatzaileanames());
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menudos) {
        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.menu,menudos);

        MenuItem search = (MenuItem) findViewById(R.id.nav_search);
        SearchView sv = (SearchView) MenuItemCompat.getActionView(search);

        return super.onCreateOptionsMenu(menudos);
    }

    public ArrayList<String> irakurri() {
        ArrayList<String> listaDatuak = new ArrayList<String>();
        BufferedReader bufferLectura = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.products);
            bufferLectura = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String linea = bufferLectura.readLine();

            while (linea != null) {

                listaDatuak.add(linea);
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listaDatuak;
    }

        public ArrayList<Products> aldatzailea(){
            ArrayList<String> produktuak = irakurri();
            ArrayList<Products> result = new ArrayList<Products>();
            for (String produktu : produktuak) {
                String[] produktuak_aldatuta = produktu.split("[,]", 0);
                for (String gauza: produktuak_aldatuta){
                    Log.d("xd", gauza);
                }
                Products p = new Products(Integer.parseInt(produktuak_aldatuta[0]), produktuak_aldatuta[1], produktuak_aldatuta[2], produktuak_aldatuta[3], produktuak_aldatuta[4], produktuak_aldatuta[5], Boolean.parseBoolean(produktuak_aldatuta[6]), Boolean.parseBoolean(produktuak_aldatuta[7]), Boolean.parseBoolean(produktuak_aldatuta[8]), Boolean.parseBoolean(produktuak_aldatuta[9]));
                result.add(p);


            }
            return result;
        }
    public  ArrayList<String> aldatzaileanames(){
        ArrayList<String> produktuak = irakurri();
        ArrayList<String> names = new ArrayList<String>();
        for (String produktu : produktuak) {
            String[] produktuak_aldatuta = produktu.split("[,]", 0);
            for (String gauza: produktuak_aldatuta){
                Log.d("xd", gauza);
            }

            names.add(produktuak_aldatuta[1]);

        }
        return names;
    }
    }