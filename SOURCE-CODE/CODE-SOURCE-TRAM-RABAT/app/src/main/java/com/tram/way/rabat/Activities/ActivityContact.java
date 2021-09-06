package com.tram.way.rabat.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tram.way.rabat.R;
import com.tram.way.rabat.Tram;

import java.util.List;

public class ActivityContact extends AppCompatActivity {
    TextView mailrecru,t_nom,t_mail,t_message;
    EditText e_nom, e_mail,e_message;
    Button bouton;
    String etoile = "*";
    String snom = "Nom ";
    String smail = "E-mail ";
    String smsg = "Message ";

    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        databaseManager=new DatabaseManager(this);

        contactMail();

        /**Nom**/
        SpannableStringBuilder buildernom = new SpannableStringBuilder(snom+etoile);

        buildernom.setSpan(new ForegroundColorSpan(Color.RED), snom.length(), buildernom.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        t_nom.setText(buildernom);

        /**Email**/
        SpannableStringBuilder buildermail = new SpannableStringBuilder(smail+etoile);

        buildermail.setSpan(new ForegroundColorSpan(Color.RED), smail.length(), buildermail.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        t_mail.setText(buildermail);

        /**Message**/
        SpannableStringBuilder buildermsg = new SpannableStringBuilder(smsg+etoile);

        buildermsg.setSpan(new ForegroundColorSpan(Color.RED), smsg.length(), buildermsg.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        t_message.setText(buildermsg);

    }
    private void contactMail()
    {

        mailrecru = findViewById(R.id.mail_recru);
        t_nom=findViewById(R.id.tnom);
        t_mail=findViewById(R.id.tmail);
        t_message=findViewById(R.id.tmessage);
        e_nom=findViewById(R.id.enom);
        e_mail=findViewById(R.id.email);
        e_message=findViewById(R.id.emessage);
        bouton=findViewById(R.id.btne);


        mailrecru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMail();

            }
        });

       bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1=e_nom.getText().toString();
                String text2=e_mail.getText().toString();
                String text3=e_message.getText().toString();
                if ((!text1.isEmpty() )&&(!text2.isEmpty() ) && (!text3.isEmpty() ))
                {
                    databaseManager.addContact(text1,text2,text3);
                    Toast.makeText(getApplicationContext(),"données inserés...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean isAvailable(Intent intent) {
        final PackageManager mgr = getPackageManager();
        List<ResolveInfo> list = mgr.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
    private void getMail(){
        Uri uri = Uri.parse(Tram.EmailRecru);
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setData(uri);
        startActivity(Intent.createChooser(sendIntent, "Send email"));

    }

    }
