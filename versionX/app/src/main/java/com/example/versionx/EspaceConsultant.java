package com.example.versionx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EspaceConsultant extends AppCompatActivity {

    Button connexionConsultant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_consultant);

        this.connexionConsultant=findViewById(R.id.buttonCon);
        connexionConsultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Support.class );
                startActivity(otherActivity);
                finish();

            }
        });
    }
}
