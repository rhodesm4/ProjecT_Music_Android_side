package com.friendzone.learning_2017;

/**
 * Created by Mortagetti on 6/3/2017.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import java.net.URLConnection;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import android.app.DownloadManager;
import android.os.AsyncTask;
import android.util.Log;


public class ServerRequest {

    private static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

}


