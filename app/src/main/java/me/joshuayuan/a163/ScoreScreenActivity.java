package me.joshuayuan.a163;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);
        int score = 0;
        Intent intent = getIntent();
        score = intent.getIntExtra("mScore", score);
        System.out.println(score);

        TextView mTV = (TextView) findViewById(R.id.score_text);
        if (mTV != null ){
            mTV.setTextSize(20);
            mTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            String str = "Well Done!\nYour Score: "+ score +"\nThere's no high score system for now,\n" +
                    "so remember this score\nif it's a new high score!";
            SpannableString ss = new SpannableString(str);
            ss.setSpan(new RelativeSizeSpan(2), 0, 25, 0);
            mTV.setText(ss);
        }
        Button mReturn = (Button) findViewById(R.id.score_return);
        if (mReturn!= null){
            mReturn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent returnIntent = new Intent(ScoreScreenActivity.this, MainActivity.class);
                    startActivity(returnIntent);
                }
            });
        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.e("back",""+1);
            Intent i=new Intent(ScoreScreenActivity.this,PlayActivity.class);
            startActivity(i);
            finish();
        }
        return true;
    }
}
