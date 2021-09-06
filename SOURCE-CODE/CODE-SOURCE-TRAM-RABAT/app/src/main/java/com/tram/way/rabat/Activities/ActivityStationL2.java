package com.tram.way.rabat.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tram.way.rabat.R;
public class ActivityStationL2 extends AppCompatActivity {
    ListView l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[]items2={" Hôpital Moulay Abdellah","Hay El Wafah","Hssain","Bab El Karia","La Rocade","Hay Moulay Ismail" ,"Zarbia","Hay Essalam","Hassan II", "Bettana", "Arrazi","Bab Lamrissa","Pont Hassan II","Place 16 novembre","Tour Hassan","Place Joulane","Bab Chellah","Médina","Ibn Rochd","Bab El Had","Place de Russie","Sidi Med Ben Abdallah"," Hôpital My Youssef", "Al Houria", "Asselam","Oued Dahab", "Yacoub El Mansour"};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_l2);

        l2 =findViewById(android.R.id.list);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(ActivityStationL2.this,R.layout.fragment_2,  R.id.textView2,items2);
        l2.setAdapter(adapter1);
    }
}