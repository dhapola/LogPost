package com.deepesh.logpostdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.logpost.android.Logger;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logInfoMessageClick(View v){
        Logger.i(TAG, "This is an Info Message...");
    }

    public void logErrorMessageClick(View v){
        try{
            throw new Exception("This is my favorite exception");
        }
        catch (Exception ex) {
            Logger.e(TAG, "This is an Error Message...", ex);
        }

    }

    public void logWarningMessageClick(View v){
        Logger.w(TAG, "This is a Warning Message...");


    }
}
