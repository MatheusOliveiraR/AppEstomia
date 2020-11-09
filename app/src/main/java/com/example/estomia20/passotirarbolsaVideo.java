package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class passotirarbolsaVideo extends AppCompatActivity {

    private VideoView vv;
    private VideoView vv2;
    private ImageButton back;
    private ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passotirarbolsa_video);

        vv = findViewById(R.id.vv1);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.tirarbolsa2pecas;
        Uri uri = Uri.parse(path);
        vv.setVideoURI(uri);
        MediaController mc = new MediaController(this);
        vv.setMediaController(mc);
        mc.setAnchorView(vv);

        vv2 = findViewById(R.id.vv2);
        String path2 = "android.resource://" + getPackageName() + "/" + R.raw.tirarbolsa1peca;
        Uri uri2 = Uri.parse(path2);
        vv2.setVideoURI(uri2);
        MediaController mc2 = new MediaController(this);
        vv2.setMediaController(mc2);
        mc2.setAnchorView(vv2);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),como_limpar_video.class));
                finish();
            }
        });
    }
}