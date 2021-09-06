package com.tram.way.rabat.Activities;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import com.Valheim.game.guide.Applications.MyApplication;
//import com.Valheim.game.guide.BuildConfig;
import com.tram.way.rabat.ServiceSetting;
import  com.tram.way.rabat.R;
import  com.tram.way.rabat.Tram;
//import com.Valheim.game.guide.Helper.SettingsPreferences;
//import com.Valheim.game.guide.UI.ImageViews;
//import com.Valheim.game.guide.UI.Particles;

import java.util.ArrayList;
import java.util.List;

public class ActivitySetting extends AppCompatActivity  implements View.OnClickListener {


    ImageView music_on ,music_off;
    ImageView back;
    TextView  privacy,moreapps;
    Intent   intentCallService4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initializeUI();

    }

    private void initializeUI(){

        music_on = findViewById(R.id.music_on);
        music_off = findViewById(R.id.music_off);
        privacy = findViewById(R.id.privacy_text);
        moreapps = findViewById(R.id.moreapps);


        back = findViewById(R.id.ic_back);




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPrivacy();
                setAnimation(privacy);
            }
        });

        moreapps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMoreApps();
                setAnimation(moreapps);
            }
        });
        intentCallService4 = new Intent(this, ServiceSetting.class);
        music_on.setOnClickListener(this);



        music_off.setOnClickListener(this);



    }

    private void getMoreApps(){

        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Tram.Tags.GGAPPS+ Tram.DeveloperName));
        if (isAvailable(mIntent)) {
            startActivity(mIntent);
        } else {
            Toast.makeText(getApplicationContext(), Tram.Tags.NotAvailableMessage, Toast.LENGTH_SHORT).show();
        }


    }

    public boolean isAvailable(Intent intent) {
        final PackageManager mgr = getPackageManager();
        List<ResolveInfo> list = mgr.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    private void getPrivacy(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Tram.PrivacyPolicy));
        if (isAvailable(intent)) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), Tram.Tags.NotAvailableMessage, Toast.LENGTH_SHORT).show();
        }
    }

    private void setAnimation(final View view){
        view.setScaleX(0.9f);
        view.setScaleY(0.9f);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setScaleX(1f);
                view.setScaleY(1f);
            }
        },50);
    }

    private void setVisible(View view, boolean isVisible){
        if (isVisible){
            view.setVisibility(View.VISIBLE);
            return;
        }
        view.setVisibility(View.GONE);
    }

    private boolean isVisible(View view){
        return view.getVisibility()==View.VISIBLE;
    }


    @Override
    public void onClick(View v) {
        if (isVisible(music_off)){
              setVisible(music_on,true);
            if (v.getId() == R.id.music_off) {
                    startService(intentCallService4);

            }

            else if (v.getId() == R.id.music_on) {

                stopService(intentCallService4);
                setVisible(music_on,false);
            }



        }

    }
}