package com.example.animationapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imageview;
    Button BTNzoom,BTNblink,BTNrotate,BTNslide,BTNmove,BTNfade,BTNstop;
    Animation loadanimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        BTNblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                imageview.startAnimation(loadanimation);
            }
        });

        BTNzoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
                imageview.startAnimation(loadanimation);
            }
        });

       BTNrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                imageview.startAnimation(loadanimation);
            }
        });

        BTNslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
                imageview.startAnimation(loadanimation);
            }
        });

        BTNmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                imageview.startAnimation(loadanimation);
            }
        });

        BTNfade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                imageview.startAnimation(loadanimation);
            }
        });

//Stop Button:
        BTNstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageview.clearAnimation();
            }
        });
    }

    void init()
    {
        imageview = findViewById(R.id.imageview);
        BTNzoom = findViewById(R.id.BTNzoom);
        BTNblink = findViewById(R.id.BTNblink);
        BTNfade = findViewById(R.id.BTNfade);
        BTNmove = findViewById(R.id.BTNmove);
        BTNrotate = findViewById(R.id.BTNrotate);
        BTNslide = findViewById(R.id.BTNslide);
        BTNstop = findViewById(R.id.BTNstop);
    }
}
