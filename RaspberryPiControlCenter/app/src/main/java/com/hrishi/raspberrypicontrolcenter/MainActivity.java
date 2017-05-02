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

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView webview = (WebView)findViewById(R.id.webview);
        webview.loadUrl("http://192.168.0.100");
        final WebView x = (WebView)findViewById(R.id.webViewx);
        x.loadUrl("http://192.168.0.100:8081/");

        Button startcam = (Button)findViewById(R.id.startcam);
        Button stopcam = (Button)findViewById(R.id.stopcam);
        Button restart = (Button)findViewById(R.id.rrpi);
        Button shutdown = (Button)findViewById(R.id.shutdown);
        Button d = (Button)findViewById(R.id.dwn);

        d.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(view.getContext(), download.class);
                startActivityForResult(intent, 1);

            }

        });

        startcam.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                webview.loadUrl("http://192.168.0.100/x.php?status=startcam");
                x.loadUrl("http://192.168.0.100:8081/");

            }

        });
        stopcam.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                webview.loadUrl("http://192.168.0.100/x.php?status=stopcam");

            }

        });
        restart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                webview.loadUrl("http://192.168.0.100/x.php?status=restart");
                x.loadUrl("http://192.168.0.100:8081/");

            }

        });
        shutdown.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                webview.loadUrl("http://192.168.0.100/x.php?status=shutdown");
                x.loadUrl("http://192.168.0.100:8081/");

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
