package com.example.thehunt;

import com.cloudmine.api.CMApiCredentials;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	static String CloudID = "bc917fe6ee7942d78e421e2ab6dcfb46";
	static String CloudKey = "6701f1a00ea8471eaa315f3535c107d1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Authentication auth = new Authentication();
		CMApiCredentials.initialize(CloudID, CloudKey, getApplicationContext());
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
            	Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            	startActivity(intent);
            }
        });
    }
}