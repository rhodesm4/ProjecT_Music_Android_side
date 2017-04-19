package com.friendzone.learning_2017;

import android.app.Activity;
import android.app.Application;
import com.parse.Parse;

/**
 * Created by Mortagetti on 3/18/2017.
 */

public class Server_Info extends Application {
    public void onCreate(){
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("123456789987654322")
                .server("http://insta3334.herokuapp.com/parse/")
                .build()
        );
//testing12
    }
}