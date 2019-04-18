package com.example.prueba5;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainAct", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainAct", "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainAct", "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainAct", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainAct", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainAct","OnDestroy()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

                //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final VideoView video= findViewById(R.id.avengers);
        System.out.println("OnCreate()");
        Log.d("MainAct","Oncreate()");
        Button play = findViewById(R.id.button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.start();
            }
        });
        Button pause = findViewById(R.id.button2);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.pause();
            }
        });

        FrameLayout gu = findViewById(R.id.tucan);


        String getpath ="android.resource://"+ getPackageName()+"/"+R.raw.avengers;
        Uri uri =Uri.parse(getpath);
        video.setVideoURI(uri);

        MediaController media = new MediaController(this);
        video.setMediaController(media);
        media.setAnchorView(gu);

        intent = new Intent(this,Drawer.class);
        ImageView Drawer = findViewById(R.id.Drawer);
        Drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        intent = new Intent(this,Drawer.class);
        intent.putExtra("VIDEO_ID","123abc");
        Button drawer = findViewById(R.id.drawer);
        drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
