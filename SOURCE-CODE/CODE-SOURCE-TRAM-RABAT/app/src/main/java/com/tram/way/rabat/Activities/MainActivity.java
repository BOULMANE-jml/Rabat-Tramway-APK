package com.tram.way.rabat.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;
import com.tram.way.rabat.R;
import com.tram.way.rabat.Tram;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Button btn_cancel, btn_okay ;
    private DrawerLayout drawer;
    NavigationView navigationview;
    TextView tex1,tex2,tex3, tex4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar=findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawer= findViewById(R.id.drawer_layout);
       navigationview=findViewById(R.id.nav_view);
        //navigationview.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle to=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(to);
        to.syncState();

       navigationview.setNavigationItemSelectedListener(this);



         tex1 =findViewById(R.id.t1);
         tex2 =findViewById(R.id.t2);
         tex3 =findViewById(R.id.t3);
         tex4 =findViewById(R.id.t4);

        tex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                Intent intent=new Intent(MainActivity.this,ActivityTicket.class);
                startActivity(intent);
            }
        });



        tex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                Intent intent1=new Intent(MainActivity.this,ActivityHoraire.class);
                startActivity(intent1);
            }
        });

        tex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                Intent intent2=new Intent(MainActivity.this,ActivityPlanLignes.class);
                startActivity(intent2);
            }
        });

        tex4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                Intent intent3=new Intent(MainActivity.this,ActivityContact.class);
                startActivity(intent3);
            }
        });

        }



    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {//is not open
            super.onBackPressed();
        }

    }



   @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_home:
                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_liststa:
                Intent intent=new Intent(MainActivity.this,ActivityStation.class);
                startActivity(intent);
                Toast.makeText(this,"Stations",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_station:
                Intent intent10=new Intent(MainActivity.this,ActivityDepartArrivee.class);
                startActivity(intent10);
                Toast.makeText(this,"Distance entre Stations ",Toast.LENGTH_SHORT).show();
                break;

            case R.id.abonn:
                Intent intent3=new Intent(MainActivity.this,ActivityAbonnement.class);
                startActivity(intent3);
                Toast.makeText(MainActivity.this, "Abonnement", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ticket:
                Intent intent4 =new Intent(MainActivity.this,ActivityTicket.class);
                startActivity(intent4);
                Toast.makeText(MainActivity.this, "Ticket et infractions", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_horaire:
                Intent intent5=new Intent(MainActivity.this,ActivityHoraire.class);
                startActivity(intent5);
                Toast.makeText(this,"Horaire",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_plan_de_lignes:
                Intent intent6=new Intent(MainActivity.this, ActivityPlanLignes.class);
                startActivity(intent6);
                Toast.makeText(this,"Plant des lignes",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_setting:
                Intent intent7=new Intent(MainActivity.this,ActivitySetting.class);
                startActivity(intent7);
                Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_contact:
                Intent intent8=new Intent(MainActivity.this,ActivityContact.class);
                startActivity(intent8);
                Toast.makeText(this,"contact",Toast.LENGTH_SHORT).show();
                break;


            case R.id.nav_logout:finish();

                Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
                break;


        }
      drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}