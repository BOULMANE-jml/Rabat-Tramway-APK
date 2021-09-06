package com.tram.way.rabat.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tram.way.rabat.R;
import com.tram.way.rabat.Tram;

import java.util.List;

public class ActivityAbonnement extends AppCompatActivity {
    TextView form,formtalib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abonnement);
        initializeUI();

    }

    private void initializeUI() {
        form = findViewById(R.id.telecharger);
        formtalib=findViewById(R.id.telecha);



        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFormIrtiyah();

            }
        });

        formtalib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFormIrtiyahTalib();

            }
        });
    }

    private void  getFormIrtiyah(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Tram.Irtiyah));
        if (isAvailable(intent)) {
            startActivity(intent);
        }
    }

    private void  getFormIrtiyahTalib(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Tram.IrtiyahTalib));
        if (isAvailable(intent)) {
            startActivity(intent);
        }
    }
    public boolean isAvailable(Intent intent) {
        final PackageManager mgr = getPackageManager();
        List<ResolveInfo> list = mgr.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}