package com.android.bigsister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class notLoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_logged_in);

        Button loginButton = (Button) findViewById(R.id.Login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked!");
                Intent loginActivityIntent = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(loginActivityIntent);
            }
        });

        Button signUpButton = (Button) findViewById(R.id.signUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpActivityIntent = new Intent(getApplicationContext(), signUpActivity.class);
                startActivity(signUpActivityIntent);
            }
        });
    }


}
