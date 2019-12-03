package com.example.versionx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class New_Ticket extends AppCompatActivity{

    Data_base_tickets data_tickets;

    Button send ,decoClient,newTicket,history;
    Spinner niveau;

    EditText subject , Des;
    Dialog myDialog;
    TextView exit;
    TextView recup;
    String test;
    String str;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__ticket);

         recup=findViewById(R.id.setText);

        send = findViewById(R.id.send_ticket);

        niveau = findViewById(R.id.Niveau);
        decoClient=findViewById(R.id.deconnexionClient);
        newTicket=findViewById(R.id.newTicket);
        subject = findViewById(R.id.Subject1);
        Des=findViewById(R.id.editText10);



        history=findViewById(R.id.history);



        data_tickets = new com.example.versionx.Data_base_tickets(this);

        Intent intent=getIntent();
        str=intent.getStringExtra("UserName");


        recup.setText(str + " est connecté");


        myDialog= new Dialog(this);
        decoClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent otherActivity = new Intent(getApplicationContext(),MainActivity.class );
                startActivity(otherActivity);
                finish();

            }
        });

        newTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),New_Ticket.class );
                startActivity(otherActivity);
                finish();

            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        niveau.setAdapter(adapter);
        AddTicket();
        ViewAllTickets();
    }


        private void AddTicket(){
           //date
            Date now = new Date();
            SimpleDateFormat formatteur = new SimpleDateFormat("dd/MM/YYYY HH:mm");
            final String result =formatteur.format(now);



            send.setOnClickListener(

                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            test=subject.getText().toString();
                            String level=niveau.getSelectedItem().toString();
                            String description=Des.getText().toString();

                            boolean isInserted=data_tickets.insertTickets(result,test,str,level,description);
                            if(isInserted==true)
                                Toast.makeText(com.example.versionx.New_Ticket.this, "Ticket Inserted Successfully", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(com.example.versionx.New_Ticket.this, "Ticket Not Inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }

    private void ViewAllTickets() {
        history.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor data=data_tickets.getTickets(str);
                        if(data.getCount()==0){
                            showMessage("Error","Merci de d'abord créé un tickets!");
                            return;
                        }
                        StringBuffer buffer= new StringBuffer();
                        while(data.moveToNext()){
                            buffer.append("Ticket_number :"+data.getString(0)+"\n");
                            buffer.append("Date :"+data.getString(1)+"\n");
                            buffer.append("Sujet :"+data.getString(2)+"\n");
                            buffer.append("de :"+data.getString(3)+"\n");
                            buffer.append("priorité :"+data.getString(4)+"\n");
                            buffer.append("Description :"+data.getString(5)+"\n");
                            buffer.append("------------------");
                        }
                        showMessage("Historique " + str,buffer.toString());

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
