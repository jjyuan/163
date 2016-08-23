package me.joshuayuan.a163;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {
    private final boolean PRACTICE_MODE = true;
    private final boolean SPEED_MODE = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button practiceButton = (Button) findViewById(R.id.practice_mode_button);
        if(practiceButton!=null){
            practiceButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PlayActivity.this, GameActivity.class);
                    intent.putExtra("gameMode", PRACTICE_MODE);
                    startActivity(intent);
                }
            });
        }

        Button speedButton = (Button) findViewById(R.id.speed_mode_button);
        if(speedButton!=null){
            speedButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PlayActivity.this, GameActivity.class);
                    intent.putExtra("gameMode", SPEED_MODE);
                    startActivity(intent);
                }
            });
        }
    }
}
