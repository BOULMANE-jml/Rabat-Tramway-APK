package com.tram.way.rabat.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.tram.way.rabat.R;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
    public class ActivityHoraire extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_horaire);



            TabLayout tabs = findViewById(R.id.tabs);
            TabItem tabb1=findViewById(R.id.horaires_ramadan);
            TabItem tabb2=findViewById(R.id.horaires_normal);
            final ViewPager viewPager = findViewById(R.id.view_pager);

            PagerAdapterHoraire pageAdapter=new PagerAdapterHoraire(getSupportFragmentManager(),tabs.getTabCount());
            viewPager.setAdapter(pageAdapter);

            tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }}