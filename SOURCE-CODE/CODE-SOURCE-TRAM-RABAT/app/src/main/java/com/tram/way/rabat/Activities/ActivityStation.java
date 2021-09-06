package com.tram.way.rabat.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

//import com.tram_icon.way.rabat.Activities.ui.main.SectionsPagerAdapter;
import  com.tram.way.rabat.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityStation extends AppCompatActivity {
    ListView l1;


    @Override
    public void onCreate(Bundle savedInstanceState) {


        String[] items = { "Hay_Karima", "Tabriquet","La Poste de Salé", "Mohammed V - OpéraDiar", "Gare de Salé-Ville","Bab Lamrissa", "Pont Hassan II", "Place 16 novembre","Tour Hassan", "Place Joulane", "Gare de Rabat-Ville","Bab Rouah", "Bibliothèque nationale","Ibn Khaldoun","Nations unies", "Agdal - Av. de France","Ibn Sina","Ibn Rochd", "Cité universitaire","Madinat Al Irfane"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        l1 =findViewById(android.R.id.list);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(ActivityStation.this,R.layout.fragment_1,  R.id.textView1,items);
        l1.setAdapter(adapter1);

        Button b1=findViewById(R.id.bli2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                Intent intent3=new Intent(ActivityStation.this,ActivityStationL2.class);
                startActivity(intent3);
            }
        });



       DatabaseManager databaseManager = new DatabaseManager(this);
/*
        databaseManager.insertStasion("Hay_Karima","k","Salé",1);
        databaseManager.insertStasion("Tabriquet","k","Salé",1);
        databaseManager.insertStasion("La Poste de Salé","k","Salé",1);
        databaseManager.insertStasion("Mohammed V - Opéra","k","Salé",1);
        databaseManager.insertStasion("Diar","k","Salé",1);
        databaseManager.insertStasion("Gare de Salé-Ville","k","Salé",1);
        databaseManager.insertStasion("Bab Lamrissa","k","Salé",1);
        databaseManager.insertStasion("Pont Hassan II","k","Rabat",1);
        databaseManager.insertStasion("Place 16 novembre","k","Rabat",1);
        databaseManager.insertStasion("Tour Hassan","k","Rabat",1);
        databaseManager.insertStasion("Place Joulane","k","Rabat",1);
        databaseManager.insertStasion("Gare de Rabat-Ville","k","Rabat",1);
        databaseManager.insertStasion("Bab Rouah","k","Rabat",1);
        databaseManager.insertStasion("Bibliothèque nationale","k","Rabat",1);
        databaseManager.insertStasion("Ibn Khaldoun","k","Rabat",1);
        databaseManager.insertStasion("Nations unies","k","Rabat",1);
        databaseManager.insertStasion("Agdal - Av. de France","k","Rabat",1);
        databaseManager.insertStasion("Ibn Sina","k","Rabat",1);
        databaseManager.insertStasion("Ibn Rochd","k","Rabat",1);
        databaseManager.insertStasion("Cité universitaire","k","Rabat",1);
        databaseManager.insertStasion("Madinat Al Irfane","k","Rabat",1);

        databaseManager.insertStasion("Hôpital Moulay Abdellah","k","Salé",2);
        databaseManager.insertStasion("Hay El Wafah","k","Salé",2);
        databaseManager.insertStasion("Hssain","k","Salé",2);
        databaseManager.insertStasion("Bab El Karia","k","Salé",2);
        databaseManager.insertStasion("La Rocade","k","Salé",2);
        databaseManager.insertStasion("Hay Moulay Ismail ","k","Salé",2);
        databaseManager.insertStasion("Zarbia","k","Salé",2);
        databaseManager.insertStasion("Hay Essalam","k","Salé",2);
        databaseManager.insertStasion("Hassan II","k","Salé",2);
        databaseManager.insertStasion("Bettana","k","Salé",2);
        databaseManager.insertStasion("Arrazi","k","Salé",2);
        databaseManager.insertStasion("Bab Lamrissa","k","Salé",2);
        databaseManager.insertStasion("Pont Hassan II ","k","Rabat",2);
        databaseManager.insertStasion("Place 16 novembre","k","Rabat",2);
        databaseManager.insertStasion("Tour Hassan","k","Rabat",2);
        databaseManager.insertStasion("Place Joulane","k","Rabat",2);
        databaseManager.insertStasion("Bab Chellah","k","Rabat",2);
        databaseManager.insertStasion("Médina","k","Rabat",2);
        databaseManager.insertStasion("Ibn Rochd","k","Rabat",2);
        databaseManager.insertStasion("Bab El Had","k","Rabat",2);
        databaseManager.insertStasion("Place de Russie","k","Rabat",2);
        databaseManager.insertStasion("Sidi Med Ben Abdallah","k","Rabat",2);
        databaseManager.insertStasion("Hôpital My Youssef","k","Rabat",2);
        databaseManager.insertStasion("Al Houria","k","Rabat",2);
        databaseManager.insertStasion("Asselam","k","Rabat",2);
        databaseManager.insertStasion("Oued Dahab","k","Rabat",2);
        databaseManager.insertStasion("Yacoub El Mansour ","k","Rabat",2);*/


        }



    }