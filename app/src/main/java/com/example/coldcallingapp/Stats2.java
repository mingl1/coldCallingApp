package com.example.coldcallingapp;

import androidx.appcompat.app.AppCompatActivity;

public class Stats2 extends AppCompatActivity{
  
private TextView name;
private Button back;

protected void onCreate(Bundle savedInstanceState) {
	name = findViewById(R.id.TextView);
  back = findViewById(R.id.BackButton);
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
  back.setOnClickListener(new View.OnClickListener() {
  public void onClick(View view) {
      Intent i = new Intent(Stats2.this, MainActivity.this);
      startActivity(i);
  }});
}
}
