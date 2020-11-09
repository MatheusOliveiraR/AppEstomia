package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class como_limpar_video extends AppCompatActivity {
    private VideoView vv1;
    private ImageButton back;
    private ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_como_limpar_video);

        vv1 = findViewById(R.id.videoview1);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.limparpele;
        Uri uri = Uri.parse(path);
        vv1.setVideoURI(uri);
        MediaController mc = new MediaController(this);
        vv1.setMediaController(mc);
        mc.setAnchorView(vv1);

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
                startActivity(new Intent(getApplicationContext(),colocar_bolsa_video.class));
                finish();
            }
        });
    }
}