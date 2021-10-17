package com.example.coldcallingapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Stats extends AppCompatActivity {
    private ListView students,number;
    private Button back;
    private ArrayList <String> names,called,numbers;
    private int [] x;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);
        Bundle extras = getIntent().getExtras();
        back = findViewById(R.id.back2);
        students=findViewById(R.id.list_view);
        number=findViewById(R.id.list_view2);
        names=extras.getStringArrayList("names");
        x=extras.getIntArray("calledList");
        called= new ArrayList<>();
        numbers= new ArrayList<>();
        called.add("Names: ");
        numbers.add("Number of times called: ");
        for (int i = 0; i < x.length; i++) {
            if (x[i] >0 ){
                called.add(names.get(i));
                numbers.add(""+x[i]);
            }
        }

        ArrayAdapter<String> listNames=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,called);

        students.setAdapter(listNames);
        ArrayAdapter<String> listCalled=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,numbers);
        number.setAdapter(listCalled);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }});
    }


}
