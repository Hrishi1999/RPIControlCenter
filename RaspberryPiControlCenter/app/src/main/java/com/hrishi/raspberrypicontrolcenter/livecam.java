package com.hrishi.raspberrypicontrolcenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class livecam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livecam);
        this.setTitle("Live Camera");

        Switch lv = (Switch)findViewById(R.id.switchlc);
        Button back = (Button)findViewById(R.id.gohome);
        final WebView cmd = (WebView)findViewById(R.id.egwv);
        lv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    final WebView x = (WebView)findViewById(R.id.lcweb);
                    cmd.loadUrl("http://192.168.0.100/x.php?status=startcam");
                    x.loadUrl("http://192.168.0.100:8081/");
                }
                else
                {
                    cmd.loadUrl("http://192.168.0.100/x.php?status=stopcam");
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }

        });
    }
    protected void onStart()
    {
        final WebView x = (WebView)findViewById(R.id.lcweb);
        x.loadUrl("http://192.168.0.100:8081/");
        super.onStart();
    }
}
