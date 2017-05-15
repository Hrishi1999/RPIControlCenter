package com.hrishi.raspberrypicontrolcenter;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView webview = (WebView)findViewById(R.id.webview);
        webview.loadUrl("http://192.168.0.100");
        Button restart = (Button)findViewById(R.id.rrpi);
        Button shutdown = (Button)findViewById(R.id.shutdown);
        Button live = (Button)findViewById(R.id.lc);

        live.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getBaseContext(), livecam.class);
                startActivity(i);
            }

        });

        restart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                webview.loadUrl("http://192.168.0.100/x.php?status=restart");

            }

        });
        shutdown.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                webview.loadUrl("http://192.168.0.100/x.php?status=shutdown");
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            Intent intent = new Intent(this, Ads.class);
            startActivityForResult(intent, 1);
            return true;        }
        return super.onOptionsItemSelected(item);
    }
}
