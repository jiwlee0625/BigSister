package com.android.bigsister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class threatActivity extends AppCompatActivity {
    private boolean underThreat = false;
    private DatabaseReference mDatabase;
    private String userFirstName;
    private String userLastName;
    private boolean alertedYet = false;
    private long lastDown = 0;
    private long lastDuration = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_threat);
        Button threatButton = (Button) findViewById(R.id.threatButton);
        threatButton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(underThreat && event.getAction() == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis();
                } else if (underThreat && event.getAction() == MotionEvent.ACTION_UP) {
                    lastDuration = System.currentTimeMillis() - lastDown;
                    if (underThreat && alertedYet == false && lastDuration >= 10000) {
                        //alrt system happen
                        //sendAlert();
                        System.out.println("Alert system called: " + lastDown + " my time: " + System.currentTimeMillis());
                        alertedYet = true;
                    }
                }
                return true;
            }
        });
        //Ji won lee needs help! Location is ______________________________
        Button deactivateButton = (Button) findViewById(R.id.stopButton);
        deactivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                underThreat = false;
                lastDown = 0;
                lastDuration = 0;
            }
        });
    }

}
