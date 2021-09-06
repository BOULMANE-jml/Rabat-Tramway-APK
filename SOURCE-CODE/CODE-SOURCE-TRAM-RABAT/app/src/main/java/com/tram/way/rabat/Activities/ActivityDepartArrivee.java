package com.tram.way.rabat.Activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import  com.tram.way.rabat.R;
public class ActivityDepartArrivee extends AppCompatActivity  {
    EditText t1,t2;
    Button bnt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depart_arrivee);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        t1 = findViewById(R.id.id1);
        t2 = findViewById(R.id.id2);
        bnt1 = findViewById(R.id.id3);
        bnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = t1.getText().toString().trim();
                String destination = t2.getText().toString().trim();
                if (source.equals("") && destination.equals("")) {
                    Toast.makeText(getApplicationContext(), "entrer la source location", Toast.LENGTH_SHORT).show();
                } else {
                    DispalyTrack(source, destination);
                }
            }

            private void DispalyTrack(String source, String destination) {
                try {
                    Uri uri=Uri.parse("https://www.google.co.in/maps/dir/"+ source + "/" +destination);
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Uri uri=Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
            }
        });
    }}
