package com.example.versionx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Support extends AppCompatActivity {

    Button newClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        this.newClient=findViewById(R.id.buttonNewClient);
        newClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),newClient1.class );
                startActivity(otherActivity);
                finish();

            }
        });
    }
}
