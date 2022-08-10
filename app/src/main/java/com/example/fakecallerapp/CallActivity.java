package com.example.fakecallerapp;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

public class CallActivity extends AppCompatActivity {
    public MediaPlayer player;
    ImageButton accept;
    ImageButton decline;
    FragmentContainerView frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_activity);
        //sound
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
    }

    public void acceptCall(View view){
        accept = findViewById(R.id.acceptBtn);
        decline = findViewById(R.id.declineBtn);
        accept.setVisibility(view.INVISIBLE);
        decline.setVisibility(view.INVISIBLE);
        player.stop();
        frag = findViewById(R.id.container);
        frag.setVisibility(view.VISIBLE);
    }
}
