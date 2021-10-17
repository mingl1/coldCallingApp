package com.example.coldcallingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Stats2 extends AppCompatActivity{

    private Button back;
    private ListView students;
    private ArrayList <String> names,called;
    private int [] x;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats2);
        back = findViewById(R.id.button3);
        Bundle extras = getIntent().getExtras();
        students=findViewById(R.id.list_view3);
        names=extras.getStringArrayList("names");
        x=extras.getIntArray("calledList");
        called= new ArrayList<>();
        called.add("Names: ");
        for (int i = 0; i < x.length; i++) {
            if (x[i] ==0 ){
                called.add(names.get(i));
            }
        }

        ArrayAdapter<String> listNames=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,called);

        students.setAdapter(listNames);


        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }});

    }



}