package me.joshuayuan.a163;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.play_button);
        if (playButton!=null){
            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        Button readmeButton = (Button) findViewById(R.id.readme_button);
        if(readmeButton!=null){
            readmeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,ReadMeActivity.class);
                    startActivity(intent);
                }
            });
        }
        Button statsButton = (Button) findViewById(R.id.stats_button);



    }
}
