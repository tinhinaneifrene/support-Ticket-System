package com.example.versionx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
            Button btn, btnShowData;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_new_client1);
                db= new com.example.versionx.SQLiteDataBaseHelper(this);
                edt1=findViewById(R.id.editTextNewClient1);
                edt2=findViewById(R.id.editTextNewClient2);
                btn=findViewById(R.id.buttonAjouter);
                AddData();
                btnShowData=findViewById(R.id.afficher_tables);
                ViewAll();

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
            private void ViewAll() {
                btnShowData.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Cursor data=db.getAllData();
                                if(data.getCount()==0){
                                    showMessage("Error","No Data Found !");
                                    return;
                                }
                                StringBuffer buffer= new StringBuffer();
                                while(data.moveToNext()){
                                    buffer.append("ID :"+data.getString(0)+"\n");
                                    buffer.append("UserName :"+data.getString(1)+"\n");
                                    buffer.append("PassWord :"+data.getString(2)+"\n");
                                }
                                showMessage("Data",buffer.toString());

                            }
                        }
                );
            }
            public void showMessage(String title, String message) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.show();
            }
}
