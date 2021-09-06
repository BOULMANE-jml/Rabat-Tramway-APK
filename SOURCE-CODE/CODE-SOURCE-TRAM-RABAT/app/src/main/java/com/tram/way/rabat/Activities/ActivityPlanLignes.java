package com.tram.way.rabat.Activities;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tram.way.rabat.R;

public class ActivityPlanLignes extends AppCompatActivity {
    private WebView mywebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planligne);
        mywebview=findViewById(R.id.web);
        mywebview.setWebViewClient(new WebViewClient());
        mywebview.loadUrl("https://www.google.com/maps/d/viewer?mid=1rvQHaCMKgeyB5VDOcEDQMu2Dh5KRZeb_&ll=34.02282597142895%2C-6.811332832625416&z=13");
        WebSettings webSettings=mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebview.canGoBack()) {
            mywebview.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}