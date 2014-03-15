package com.example.thehunt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        Button logButton = (Button) findViewById(R.id.button3);
        logButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	//Set up new log in credentials from Cloudmine.
            }
        });
    }
}