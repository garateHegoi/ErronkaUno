package com.example.erronkauno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Serializable {
    ListView lv;
    int n = 0;
    ArrayList<Products> result = new ArrayList<Products>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aldatzailea();
        Log.d("result says", result.get(0).getName());
        lv = (ListView) findViewById(R.id.tv_emptyTextView);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,aldatzaileanames());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (Products a:result) {
                    if (a.getName().equals(adapter.getItem(i))){
                        Log.d("result says", a.getID()+"");
                        Intent datos = new Intent(MainActivity.this,MainActivity2.class);
                        datos.putExtra("id",a.getID()+"");
                        datos.putExtra("name",a.getName());
                        datos.putExtra("list_price",a.getList_price());
                        datos.putExtra("description",a.getDescription());
                        datos.putExtra("volume",a.getVolume());
                        datos.putExtra("weight",a.getWeight());
                        datos.putExtra("stock",a.getStock());
                        datos.putExtra("imagen",a.getImagen());
                        datos.putExtra("sale_ok",a.isSale_ok()+"");
                        datos.putExtra("active",a.isActive()+"");
                        datos.putExtra("published",a.isIs_published()+"");
                        startActivity(datos);
                    }
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_op,menu);
        MenuItem menuItem = menu.findItem(R.id.nav_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
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

    public void aldatzailea(){
       ArrayList<String> produktuak = irakurri();
        for (String produktu : produktuak) {
            String[] produktuak_aldatuta = produktu.split("[|]", 0);
            for (String gauza : produktuak_aldatuta) {
                Log.d("xd", gauza);
            }
            Products p = new Products(Integer.parseInt(produktuak_aldatuta[0]), produktuak_aldatuta[1], produktuak_aldatuta[2], produktuak_aldatuta[3], produktuak_aldatuta[4], produktuak_aldatuta[5],produktuak_aldatuta[6], produktuak_aldatuta[7], Boolean.parseBoolean(produktuak_aldatuta[8]), Boolean.parseBoolean(produktuak_aldatuta[9]), Boolean.parseBoolean(produktuak_aldatuta[10]));
            result.add(p);
        }
    }


    public  ArrayList<String> aldatzaileanames(){
        ArrayList<String> produktuak = irakurri();
        ArrayList<String> names = new ArrayList<String>();
        for (String produktu : produktuak) {
            String[] produktuak_aldatuta = produktu.split("[|]", 0);
            for (String gauza: produktuak_aldatuta){
                Log.d("xd", gauza);
            }

            names.add(produktuak_aldatuta[1]);

        }
        return names;
    }

    /*public ArrayList<String> aldatzaileastring(int index){
        ArrayList<String> produktuak = irakurri();
        ArrayList<String> result = new ArrayList<>();
        String[] produktuak_aldatuta = produktuak.get(index).split("[,]", 0);
        for (int i= 0; i < produktuak_aldatuta.length; i++){
            result.add(produktuak_aldatuta[i]);
        }
        return result;
        }*/

    }
