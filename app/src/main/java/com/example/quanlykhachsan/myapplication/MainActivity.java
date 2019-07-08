package com.example.quanlykhachsan.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
private TextView tvtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvtitle=findViewById(R.id.tvtitle);
        //loadData();
        Mytask mytask=new Mytask(tvtitle);
        mytask.execute("http://docbao.vn");
    }

    public void loadData(){


        try {
          URL  url = new URL("http://docbao.vn");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            Scanner scanner=new Scanner(inputStream);
            String data="";
            while (scanner.hasNext()){
                data= scanner.nextLine()+data;
            }
            scanner.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public class Mytask extends AsyncTask<String,Long,String>{
//
//        //phuong thuc xu ly thread, luu y: ko tuong tac voi giao dien
//        @Override
//        protected String doInBackground(String... strings) {
//            try {
//                URL  url = new URL(strings[0]);
//                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
//                InputStream inputStream=httpURLConnection.getInputStream();
//                Scanner scanner=new Scanner(inputStream);
//                String data="";
//                while (scanner.hasNext()){
//                    data= scanner.nextLine()+data;
//                }
//
//                scanner.close();
//                return data;
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//
//
//        //ket thu thread
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            tvtitle.setText(s);
//        }
//    }
}
