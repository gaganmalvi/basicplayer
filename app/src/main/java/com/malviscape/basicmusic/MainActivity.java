package com.malviscape.basicmusic;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Status int, 0 for play, 1 for pause
    int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declarations
        ImageView btn = findViewById(R.id.imageButton);
        TextView txt = findViewById(R.id.textView);

        // Create MediaPlayer Object
        MediaPlayer mBasicPlayer = MediaPlayer.create(this, R.raw.music);

        // Set music loop to true
        mBasicPlayer.setLooping(true);

        btn.setOnClickListener(v -> {
            switch(status) {
                case 0:
                    // Play case
                    mBasicPlayer.start();
                    status = 1;
                    txt.setText(R.string.play);
                    btn.setImageResource(R.drawable.ic_baseline_pause_24);
                    break;
                case 1:
                    // Pause
                    mBasicPlayer.pause();
                    status = 0;
                    txt.setText(R.string.pause);
                    btn.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    break;
            }
        });
    }
}