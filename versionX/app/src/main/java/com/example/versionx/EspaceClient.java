package com.example.versionx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class EspaceClient extends AppCompatActivity {
    SQLiteDataBaseHelper db;

    EditText e1,e2;
    Button connexionClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new SQLiteDataBaseHelper(this);
        setContentView(R.layout.activity_espace_client);

        connexionClient=findViewById(R.id.buttonCli);
        e1=findViewById(R.id.UsernameClient);
        e2=findViewById(R.id.passwordClient);

        connexionClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "veuillez remplir tout les champs", Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent otherActivity = new Intent(getApplicationContext(), New_Ticket.class);
                    startActivity(otherActivity);
                    finish();

                }
            }
        });



        }


}
