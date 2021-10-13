package com.example.coldcallingapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
    private ArrayList <String>list;
    private ListView students;
    private XmlPullParserFactory xmlFactoryObject;
    private XmlPullParser myParser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);
        try {
            xmlFactoryObject=XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try {
            myParser=  xmlFactoryObject.newPullParser();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        MainActivity y = new MainActivity();
        list = new ArrayList<String>();
        students=findViewById(R.id.list_view);

        for (int x = 0; x < y.getDrawables().length; x++) {
            if (y.getCalledOrNot()[x] == true) {
                InputStream is = null;
                try {
                    is = getAssets().open("image"+(x+1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    myParser.setInput(is, null);
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
                int event = 0;
                try {
                    event = myParser.getEventType();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
                while (event != XmlPullParser.END_DOCUMENT)  {
                    String name=myParser.getName();
                    switch (event){
                        case XmlPullParser.START_TAG:
                            break;

                        case XmlPullParser.END_TAG:
                            if(name.equals("image_name")){
                                list.add(myParser.getAttributeValue(null,"value"));
                            }
                            break;
                    }
                    try {
                        event = myParser.next();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        students.setAdapter(arrayAdapter);
    }


}
