package com.example.versionx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnClient;
    Button btnConsultant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnClient=findViewById(R.id.buttonClient);
        btnClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent otherActivity = new Intent(getApplicationContext(),EspaceClient.class );
                startActivity(otherActivity);
                finish();

            }
        });

        this.btnConsultant=findViewById(R.id.buttonConsultant);
        btnConsultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent otherActivity = new Intent(getApplicationContext(),EspaceConsultant.class );
                startActivity(otherActivity);
                finish();

            }
        });

    }

}
