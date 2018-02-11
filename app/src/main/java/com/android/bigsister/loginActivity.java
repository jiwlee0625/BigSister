package com.android.bigsister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("On create of loginactivity");
        super.onCreate(savedInstanceState);
        System.out.println("After super create");
        setContentView(R.layout.activity_login);
        System.out.println("After layout");
    }
}
