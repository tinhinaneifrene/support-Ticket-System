package com.example.versionx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class Support extends AppCompatActivity {
    Data_base_tickets data_tickets;

    Button newClient,btnDeco;
    GridLayout tableau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        data_tickets = new com.example.versionx.Data_base_tickets(this);

        btnDeco=findViewById(R.id.buttonDeco);

        this.newClient=findViewById(R.id.buttonNewClient);
        newClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newclient = new Intent(getApplicationContext(),newClient1.class );
                startActivity(newclient);
                finish();

            }
        });

        tableau=findViewById(R.id.MYTable);

        tableau.setRowCount(20);
        ViewAllTickets();

        btnDeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent back = new Intent(getApplicationContext(),MainActivity.class );
                startActivity(back);
                finish();

            }
        });



    }


    private void ViewAllTickets() {
        Cursor data = data_tickets.getAllTickets();

        if (data.getCount() == 0) {
            showMessage("Error", "No Data Found !");
            return;
        }

        while (data.moveToNext()) {
            //number
            TextView number = new TextView(tableau.getContext());
            number.setText(data.getString(0));
            tableau.addView(number);
            //date
            TextView date = new TextView(tableau.getContext());
            date.setText(data.getString(1));
            tableau.addView(date);
            //sourcedate
            TextView source = new TextView(tableau.getContext());
            source.setText(data.getString(3));
            tableau.addView(source);

            //sujet du ticket
            TextView Sujet = new TextView(tableau.getContext());
            Sujet.setText(data.getString(2));
            tableau.addView(Sujet);

            //Niveau
            TextView Niveau = new TextView(tableau.getContext());
            Niveau.setText(data.getString(4));
            tableau.addView(Niveau);
            //description
            TextView Description = new TextView(tableau.getContext());
            Description.setText(data.getString(5));
            tableau.addView(Description);


        }
    }



    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
