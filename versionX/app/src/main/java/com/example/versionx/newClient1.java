package com.example.versionx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newClient1 extends AppCompatActivity {

    SQLiteDataBaseHelper db;

            EditText edt1;
            EditText edt2;
            Button btn, btnBack;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_new_client1);
                db= new com.example.versionx.SQLiteDataBaseHelper(this);
                edt1=findViewById(R.id.editTextNewClient1);
                edt2=findViewById(R.id.editTextNewClient2);
                btn=findViewById(R.id.buttonAjouter);
                btnBack=findViewById(R.id.btnBack);
                AddData();

                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent back = new Intent(getApplicationContext(),Support.class );
                        startActivity(back);
                        finish();

                    }
                });

            }



            private void AddData() {
                btn.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                boolean isInserted=db.insertData(edt1.getText().toString(),edt2.getText().toString());
                                if(isInserted==true)
                                    Toast.makeText(com.example.versionx.newClient1.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(com.example.versionx.newClient1.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }
}
