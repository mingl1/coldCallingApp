package com.example.coldcallingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private TextView className, name;
    private Button buttonView,calledLog,uncalledLog;
    private ImageView icon;
    private String cName;
    private int[] students, drawables;
    private long[] timeSince, timeStart;
    private boolean[] calledOrNot;
    private ArrayList<String> studentNames;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawables = new int[]{R.drawable.aamirali,  R.drawable.adrianyan,  R.drawable.alexaney, R.drawable.bipradey, R.drawable.darrendong, R.drawable.denniswang, R.drawable.dhruvamin, R.drawable.dultsin,
                R.drawable.edenkogan, R.drawable.elibui, R.drawable.eliebelkin, R.drawable.evelynpaskhaver, R.drawable.fardiniqbal, R.drawable.jerryhe, R.drawable.kennycao, R.drawable.marcrosenberg,
                R.drawable.matthewchen, R.drawable.michael, R.drawable.minglin, R.drawable.mohammedihtisham, R.drawable.noam, R.drawable.ralfpacia, R.drawable.samueliskhakov, R.drawable.sean, R.drawable.sebastianmarinescu ,R.drawable.selinali, R.drawable.shuyuechen, R.drawable.tanushrisundaram, R.drawable.vasu, R.drawable.xinruige, R.drawable.zhianmaysoon};
        studentNames = new ArrayList<>();
        studentNames.add("Asmirali");
        studentNames.add("Adrian Yan");
        studentNames.add("Alex Aney");
        studentNames.add("Bipradey");
        studentNames.add("Darren Dong");
        studentNames.add("Dennis Wang");
        studentNames.add("Dhruv Amin");
        studentNames.add("Dultsin");
        studentNames.add("Eden Kogan");
        studentNames.add("Eli Bui");
        studentNames.add("Ellie Belkin");
        studentNames.add("Evelyn Paskhaver");
        studentNames.add("Fardin Iqbal");
        studentNames.add("Jerry He");
        studentNames.add("Kenny Cao");
        studentNames.add("Marc Rosenbarg");
        studentNames.add("Matthew chen");
        studentNames.add("Micheal");
        studentNames.add("Ming Lin");
        studentNames.add("Mohammed Itisham");
        studentNames.add("Noam");
        studentNames.add("Ralf");
        studentNames.add("Samuel");
        studentNames.add("Sean");
        studentNames.add("Sebastion");
        studentNames.add("Selina");
        studentNames.add("Shuyue");
        studentNames.add("tanushri");
        studentNames.add("Vasu");
        studentNames.add("Xinrui");
        studentNames.add("Zhian");
        students = new int[drawables.length];
        timeSince = new long[drawables.length];
        timeStart = new long[drawables.length];
        calledOrNot = new boolean[drawables.length];
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
                if (students[num] ==0) {
                    //first time a student has been called
                    timeSince[num] = System.currentTimeMillis();
                    called(num);
                } else if (students[num]==1){
                    timeStart[num]=System.currentTimeMillis();
                    if (timeStart[num] - timeSince[num] > 2400000) {
                        timeSince[num]=timeStart[num];
                        students[num]--;
                    }
                    called(num);
                }
                else{
                    //third time program has chosen student, so it checks whether the student has been called twice within the last 40 minutes
                    timeStart[num]=System.currentTimeMillis();
                    //if the student has been called twice, it randomizes again
                    if (timeStart[num] - timeSince[num] < 2400000) {
                        timeSince[num] = System.currentTimeMillis();
                        view.callOnClick();
                    }
                    //if it has been 40 minutes since the first time the student has been called, the student's last time called is set to current time
                    else{
                        timeSince[num]=timeStart[num];
                        called(num);
                    }
                }

            }
        });
        calledLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Stats.class);
                i.putExtra("calledList", students);
                i.putExtra("drawables", drawables);
                i.putExtra("names",studentNames);
                startActivity(i);
            }});
        uncalledLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Stats2.class);
                i.putExtra("calledList", students);
                i.putExtra("drawables", drawables);
                i.putExtra("names",studentNames);
                startActivity(i);
            }});
    }
        public void called ( int num){
            icon.setImageResource(drawables[num]);
            //get name of file, placeholder
            name.setText("" + studentNames.get(num));
            //keep count of # times student been called
            students[num]++;
        }


    }