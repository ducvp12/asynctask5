package com.example.quanlykhachsan.myapplication;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Mytask extends AsyncTask<String,Long,String> {
    public Mytask(TextView tvtitle){
        this.tvtitle=tvtitle;
    }
    TextView tvtitle;


    //phuong thuc xu ly thread, luu y: ko tuong tac voi giao dien
    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            Scanner scanner=new Scanner(inputStream);
            String data="";
            while (scanner.hasNext()){
                data= scanner.nextLine()+data;
            }

            scanner.close();
            return data;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    //ket thu thread
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvtitle.setText(s);
    }
}

