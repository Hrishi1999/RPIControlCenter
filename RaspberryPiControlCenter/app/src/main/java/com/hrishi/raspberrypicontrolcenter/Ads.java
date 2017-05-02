package com.hrishi.raspberrypicontrolcenter;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Ads extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);


        WebView pi = (WebView)findViewById(R.id.pihole);
        pi.getSettings().setJavaScriptEnabled(true);
        pi.setWebViewClient(new WebViewClient());
        pi.loadUrl("http://192.168.0.100/admin");
    }
}
