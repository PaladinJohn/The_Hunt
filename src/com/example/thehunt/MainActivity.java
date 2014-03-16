package com.example.thehunt;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //authentication goes here.
        Button logButton = (Button) findViewById(R.id.button1);
        Button signButton = (Button) findViewById(R.id.button2);
		logButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(MainActivity.this, LogInActivity.class);
            	startActivity(intent);
            }
        });
		signButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	//Create new log in credentials and store them on Cloudmine.
            }
        });
    }
}