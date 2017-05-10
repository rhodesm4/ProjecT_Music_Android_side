package com.friendzone.learning_2017;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mySong = MediaPlayer.create(Main2Activity.this, R.raw.daft);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This pyramids shall rise again all hail Psedo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ListView myListView= (ListView) findViewById(R.id.myListView);

        ArrayList<String> peopleFollowed = new ArrayList<String>();
        peopleFollowed.add("Tony");
        peopleFollowed.add("Brenden");
        peopleFollowed.add("Alyse");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,peopleFollowed);
        myListView.setAdapter(arrayAdapter);

        final Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void play(View v){
        mySong.start();
    }

}
