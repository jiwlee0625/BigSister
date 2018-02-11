package com.android.bigsister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.view.MotionEvent;
import com.google.firebase.database.*;

import java.util.Timer;

public class threatActivity extends AppCompatActivity {
    private boolean underThreat = false;
    private DatabaseReference mDatabase;
    private String userFirstName;
    private String userLastName;
    private boolean alertedYet = false;
    final Timer timer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_threat);
        Button threatButton = (Button) findViewById(R.id.threatButton);
        threatButton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        //Ji won lee needs help! Location is ______________________________
        Button deactivateButton = (Button) findViewById(R.id.startStopButton);
        deactivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("startStopButton Button Clicked.");
            }
        });
    }

}
