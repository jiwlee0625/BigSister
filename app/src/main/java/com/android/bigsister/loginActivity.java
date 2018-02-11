package com.android.bigsister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

public class loginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        Button loginButton = (Button) findViewById(R.id.loginButton);
        final EditText emailInput = (EditText)findViewById(R.id.emailInput);
        final EditText pwInput = (EditText)findViewById(R.id.pwInput);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = pwInput.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent homeActivityIntent = new Intent(getApplicationContext(), homeActivity.class);
                                    startActivity(homeActivityIntent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    emailInput.setText("");
                                    pwInput.setText("");
                                }
                            }
                        });
                //Intent loginActivityIntent = new Intent(getApplicationContext(), loginActivity.class);
                //startActivity(loginActivityIntent);
            }
        });
    }
}
