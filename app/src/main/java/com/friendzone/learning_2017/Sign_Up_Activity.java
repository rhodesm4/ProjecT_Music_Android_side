package com.friendzone.learning_2017;

import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.parse.Parse;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.app.Application;
import android.widget.EditText;
import android.widget.TextView;
import android.net.NetworkRequest;
import android.widget.Toast;
import com.android.volley.toolbox.JsonRequest;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import java.io.IOException;

public class Sign_Up_Activity extends AppCompatActivity {
    ServerRequest ServerRequest = new ServerRequest();

    EditText nameInput;
    EditText passwordInput;
    EditText confirmPasswordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

    //need Username, birthday, gender
    nameInput = (EditText) findViewById(R.id.new_username);
    passwordInput = (EditText) findViewById(R.id.new_password);
    confirmPasswordInput = (EditText) findViewById(R.id.confirm_password);
    }
    public void signup(View view) {
        // added JSON request and updated the copy of gradle and android studio JsonRequest
        if (!passwordInput.getText().toString().equals(confirmPasswordInput.getText().toString())) {
            Toast.makeText(getApplicationContext(), "The passwords do not match", Toast.LENGTH_LONG).show();
        } else {
            String json = "name:" + " " + nameInput.getText() + " " + "password:" + " " + passwordInput.getText() + " ";
            ServerRequest.post("http://10.0.3.2:8000/signup", json, new Callback() {
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
        }
    }




}

