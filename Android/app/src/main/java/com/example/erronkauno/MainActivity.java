package com.example.erronkauno;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Products> result = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aldatzailea();
        lv = (ListView) findViewById(R.id.tv_emptyTextView);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, names);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            for (Products a:result) {
                if (a.getName().equals(adapter.getItem(i))){
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
        ArrayList<String> listaDatuak = new ArrayList<>();
        BufferedReader bufferLectura = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.products);
            bufferLectura = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
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
            Products p = new Products(Integer.parseInt(produktuak_aldatuta[0]), produktuak_aldatuta[1], produktuak_aldatuta[2], produktuak_aldatuta[3], produktuak_aldatuta[4], produktuak_aldatuta[5],produktuak_aldatuta[6], produktuak_aldatuta[7], Boolean.parseBoolean(produktuak_aldatuta[8]), Boolean.parseBoolean(produktuak_aldatuta[9]), Boolean.parseBoolean(produktuak_aldatuta[10]));
            result.add(p);
            names.add(produktuak_aldatuta[1]);
        }
    }
}
