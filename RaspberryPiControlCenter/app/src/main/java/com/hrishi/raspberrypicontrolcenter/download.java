package com.hrishi.raspberrypicontrolcenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class download extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Button dx = (Button)findViewById(R.id.buttondwn);
        WebView pi = (WebView)findViewById(R.id.pihole);
        pi.getSettings().setJavaScriptEnabled(true);
        pi.setWebViewClient(new WebViewClient());

        dx.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {

            }

        });
    }
}
