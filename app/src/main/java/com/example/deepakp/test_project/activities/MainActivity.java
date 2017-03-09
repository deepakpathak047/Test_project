package com.example.deepakp.test_project.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.deepakp.test_project.R;
import com.example.deepakp.test_project.adapters.ListViewCustomAdaptor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ListViewCustomAdaptor customAdapter;
    ArrayAdapter arrayAdapter;
    Activity activity;
    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<String>();
        gridView = (GridView) findViewById(R.id.gridview);
        activity = this;

        arrayList.add("Play Game");
        arrayList.add("Start Chat");

        customAdapter = new ListViewCustomAdaptor(gridView, arrayList, activity);
        gridView.setAdapter(customAdapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, PlayGameActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, ChatActivity.class));
                }
            }
        });

    }


}
