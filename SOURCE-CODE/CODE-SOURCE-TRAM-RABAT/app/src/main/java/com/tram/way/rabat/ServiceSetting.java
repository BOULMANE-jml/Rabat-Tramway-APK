package com.tram.way.rabat;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class ServiceSetting extends Service  {


    public static boolean boolIsServiceCreated = false;
    MediaPlayer player ;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "ServiceSetting Created", Toast.LENGTH_LONG).show();
        Log.e("ServiceSetting", "onCreate");
        boolIsServiceCreated = true;
        player = MediaPlayer.create(getApplicationContext(),R.raw.music_tram);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "ServiceSetting Stopped", Toast.LENGTH_LONG).show();
        Log.e("ServiceSetting", "onDestroy");
        player.stop();
        player.release();
        player = null;
    }


    @Override
    public void onStart(Intent intent, int startid) {
        if (player.isPlaying())
            Toast.makeText(this, "MyService Already Started " + startid,
                    Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "ServiceSetting Started " + startid,
                    Toast.LENGTH_LONG).show();
        Log.e("ServiceSetting", "onStart");
        player.start();
    }


}