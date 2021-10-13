package com.example.coldcallingapp;

import androidx.appcompat.app.AppCompatActivity;

public class Stats2 extends AppCompatActivity{
  
private TextView name;

protected void onCreate(Bundle savedInstanceState) {
	name = findViewById(R.id.TextView);
	MainActivity x = new MainActivity();
	super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_cheat);
  String list = "";
  for (int x = 0; x < x.getDrawables().length; x++) {
  	if (x.getCalledorNot()[x] == false {
    	list += x.getDrawables[x];
    }
  }
  name.setText(list);
}    
}
