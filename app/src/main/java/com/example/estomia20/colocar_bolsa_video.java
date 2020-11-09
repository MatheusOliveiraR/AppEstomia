package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class colocar_bolsa_video extends AppCompatActivity {
    private ImageButton back;
    private VideoView vv1;
    private VideoView vv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocar_bolsa_video);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        vv1 = findViewById(R.id.videoviewColocar);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.colocar1peca;
        Uri uri = Uri.parse(path);
        vv1.setVideoURI(uri);
        MediaController mc = new MediaController(this);
        vv1.setMediaController(mc);
        mc.setAnchorView(vv1);

        vv2 = findViewById(R.id.videoviewColocar1);
        String path2 = "android.resource://" + getPackageName() + "/" + R.raw.colocar2peca;
        Uri uri2 = Uri.parse(path2);
        vv2.setVideoURI(uri2);
        MediaController mc2 = new MediaController(this);
        vv2.setMediaController(mc2);
        mc2.setAnchorView(vv2);




    }
}