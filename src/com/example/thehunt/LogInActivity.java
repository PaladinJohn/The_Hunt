package com.example.thehunt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_activity);
        Button logButton = (Button) findViewById(R.id.button4);
        logButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	//Get log in credentials from Cloudmine.
            }
        });
    }
}