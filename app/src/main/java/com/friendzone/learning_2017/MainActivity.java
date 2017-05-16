package com.friendzone.learning_2017;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.parse.Parse;
import android.app.Application;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.new_button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


        final TextView Sign_up = (TextView) findViewById(R.id.sign_up);
        Sign_up.setOnClickListener(new View.OnClickListener(){
                public void onClick(View x){
                    Intent sign_intent = new Intent(MainActivity.this, Sign_Up_Activity.class);
                    startActivity(sign_intent);
                }
            });


    }
}
class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this);
    }
}
