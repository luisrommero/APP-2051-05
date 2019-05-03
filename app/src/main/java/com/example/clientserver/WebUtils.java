package com.example.clientserver;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebUtils extends AsyncTask<String,Void,String> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";

    @Override
    protected String doInBackground(String... params) {
        try {
            String URLString = params[0];
            URL url = new URL(URLString); //https://api.myjson.com/bins/j5f6b
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            return (data);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.d(">>>APP:", e.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(String Result) {
        super.onPostExecute(Result);

        //MainActivity.data.setText(this.dataParsed);

    }
}