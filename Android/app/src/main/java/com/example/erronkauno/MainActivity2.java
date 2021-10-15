package com.example.erronkauno;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.*;
import android.graphics.BitmapFactory;

public class MainActivity2 extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String ide = getIntent().getStringExtra("id");

        Toast.makeText(MainActivity2.this, ide+"", Toast.LENGTH_SHORT).show();
        Product p = new Product(Integer.parseInt(getIntent().getStringExtra("id")),
                getIntent().getStringExtra("name"),
                getIntent().getStringExtra("list_price"),
                getIntent().getStringExtra("description"),
                getIntent().getStringExtra("volume"),
                getIntent().getStringExtra("weight"),
                getIntent().getStringExtra("stock"),
                getIntent().getStringExtra("imagen"),
                Boolean.parseBoolean(getIntent().getStringExtra("sale_ok")),
                Boolean.parseBoolean(getIntent().getStringExtra("active")),
                Boolean.parseBoolean(getIntent().getStringExtra("published")));

        Toast.makeText(MainActivity2.this, p.getName(), Toast.LENGTH_SHORT).show();
        ImageView imagen = (ImageView) findViewById(R.id.imageView);

        byte[] decodedString = Base64.decode(p.getImagen(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        imagen.setImageBitmap(decodedByte);

        /*  */

        TextView name = (TextView) findViewById(R.id.nameTV);
        name.setText(p.getName());
        TextView description = (TextView) findViewById(R.id.descriptionTV);
        description.setText(p.getDescription());
        TextView price = (TextView) findViewById(R.id.priceTV);
        price.setText(p.getList_price() + "€");
        TextView volume = (TextView) findViewById(R.id.volumeTV);
        volume.setText("VOLUME\n"+p.getVolume());
        TextView weight = (TextView) findViewById(R.id.weightTV);
        weight.setText("WEIGHT\n"+p.getWeight());
        TextView active = (TextView) findViewById(R.id.activeTV);
        active.setText("ACTIVE\n"+p.isActive());
        if(p.isActive()){
            active.setBackgroundColor(Color.rgb(25, 178, 45));
        }else{
            active.setBackgroundColor(Color.rgb(253, 45, 0));
        }
        TextView published = (TextView) findViewById(R.id.publishedTV);
        published.setText("PUBLISHED\n"+p.is_published);
        if(p.isIs_published()){
            published.setBackgroundColor(Color.rgb(25, 178, 45));
        }else{
            published.setBackgroundColor(Color.rgb(253, 45, 0));
        }
        TextView quantity = (TextView) findViewById(R.id.quantityTV);
        quantity.setText("STOCK\n"+p.getStock());

        TextView sale_ok = (TextView) findViewById(R.id.sale_okTV);
        sale_ok.setText("ON SALE\n"+p.isSale_ok());
        if(p.isSale_ok()){
            sale_ok.setBackgroundColor(Color.rgb(25, 178, 45));
        }else{
            sale_ok.setBackgroundColor(Color.rgb(253, 45, 0));
        }
    }

}