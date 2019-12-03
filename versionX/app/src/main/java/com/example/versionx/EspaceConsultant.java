package com.example.versionx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EspaceConsultant extends AppCompatActivity {

    EditText e1,e2;

    Button connexionConsultant,backConsultant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_consultant);

        connexionConsultant=findViewById(R.id.buttonCon);
        e1=findViewById(R.id.editText3);
        e2=findViewById(R.id.editText4);
        backConsultant=findViewById(R.id.backConsultant);


        backConsultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent backConsultant = new Intent(getApplicationContext(),MainActivity.class );
                startActivity(backConsultant);
                finish();

            }
        });


        connexionConsultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "veuillez remplir tout les champs", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s1.equals("admin") && s2.equals("admin1")){

                        Intent intentConsu = new Intent(getApplicationContext(), Support.class);
                        startActivity(intentConsu);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Connexion echoué", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }
}
