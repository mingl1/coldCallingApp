package com.example.coldcallingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView className, name;
    private Button buttonView,calledLog,uncalledLog;
    private ImageView icon;
    private String cName;
    private int[] students, drawables;
    private long[] timeSince, timeStart;
    private boolean[] calledOrNot;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawables = new int[]{R.drawable.image1, R.drawable.image2};
        students = new int[drawables.length];
        timeSince = new long[drawables.length];
        timeStart = new long[drawables.length];
        calledOrNot = new boolean[drawables.length];
        //R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16, R.drawable.image17, R.drawable.image18, R.drawable.image19, R.drawable.image2-0, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1);
        buttonView = findViewById(R.id.button);
        icon = findViewById(R.id.icon);
        name = findViewById(R.id.textView2);
        className = findViewById(R.id.className);
        calledLog=findViewById(R.id.calledLog);
        uncalledLog=findViewById(R.id.unCalledLog);
        //change later to get name of class
        cName = "App Dev Class";
        className.setText(cName);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = (int) (Math.random() * drawables.length);
                if (calledOrNot[num] == false) {
                    calledOrNot[num] = true;
                    timeSince[num] = System.currentTimeMillis();
                    called(num);
                } else {
                    timeStart[num]=System.currentTimeMillis();
                    for (int i = 0; i < drawables.length; i++) {
                        if (calledOrNot[i] == false) {
                           view.callOnClick();
                        }
                    }

                    if (timeStart[num] - timeSince[num] < 2400000) {
                        timeSince[num] = System.currentTimeMillis();
                    }

                }

            }
        });
        calledLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Stats.class);
                startActivity(i);
            }});
        uncalledLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Stats2.class);
                startActivity(i);
            }});
    }
        public void called ( int num){
            icon.setImageResource(drawables[num]);
            //get name of file, placeholder
            name.setText("" + num);
            //keep count of # times student been called
            students[num]++;
        }

        public boolean []getCalledOrNot(){
            return calledOrNot;
        }

        public int [] getDrawables(){
            return drawables;
        }

    }