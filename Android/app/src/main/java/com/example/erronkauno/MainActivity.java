package com.example.erronkauno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TableLayout tl;
    int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //tl = (TableLayout) findViewById(R.id.taula);

    }

    public void gehitu(View view){
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));


        for (int i = 0; i<4;i++){
            Button b = new Button(this);
            b.setClickable(false);
            b.setText(n+"_x"+i);
            tr.addView(b);
        }
        tl.addView(tr);
        Log.d("klik", "sdfil");
    }
}