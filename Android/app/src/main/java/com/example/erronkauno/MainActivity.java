package com.example.erronkauno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;


import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TableLayout tl;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = (TableLayout) findViewById(R.id.taula);
        ArrayList<Products> produktuak = aldatzailea();
        for (Products produktua : produktuak) {
            TableRow tr = new TableRow(this);
            Button id = new Button(this);
            id.setText(String.valueOf(produktua.getID()));
            tr.addView(id);
            Button name = new Button(this);
            name.setText(produktua.getName());
            tr.addView(name);
            Button price = new Button(this);
            price.setText(String.valueOf(produktua.getList_price()));
            tr.addView(price);
            tl.addView(tr);
        }

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
    }