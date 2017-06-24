package com.friendzone.learning_2017;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
//import android.view.View;
import android.view.View;
import android.widget.Button;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.parse.Parse;
import android.app.Application;
import android.widget.EditText;
import android.widget.TextView;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import android.net.NetworkRequest;
import android.widget.Toast;

import java.io.IOException;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText Username;
    EditText Password;
    ServerRequest Request = new ServerRequest();
    String url = "http://ip.jsontest.com/";
    String requestBody = "";

    /*public void login(View view) {
        String json = "{"+"name:" + "" + Username.getText() +","+ "" + "password:" + "" + Password.getText() + "";
        Request.post("http://exampleip:8000/"+Username.getText().toString(), json, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }
            @Override
            public void onResponse(Response response) throws IOException {
                String responseStr = response.body().string();
                final String messageText = "Status code : " + response.code() +
                        "n" +
                        "Response body : " + responseStr;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), messageText, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = (Button) findViewById(R.id.new_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


        final TextView Sign_up = (TextView) findViewById(R.id.sign_up);
        Sign_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View x) {
                Intent sign_intent = new Intent(MainActivity.this, Sign_Up_Activity.class);
                startActivity(sign_intent);
            }
        });

         Username = (EditText) findViewById(R.id.username);
         Password = (EditText) findViewById(R.id.password);
        final Button Login = (Button) findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, url, requestBody, new com.android.volley.Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), "Successful Login", Toast.LENGTH_LONG).show();
                        Intent login_in = new Intent(MainActivity.this, Actual_App.class);
                        startActivity(login_in);

                    }
                }, new com.android.volley.Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError arg0) {
                        // TODO Auto-generated method stub
                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);
            }
        });
    }
}