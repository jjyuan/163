package me.joshuayuan.a163;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    private static final int ONE_MINUTE = 60000;
    private static final int TWO_MINUTES = 120000;
    private static final int FIVE_MINUTES = 300000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button mOneMinute = (Button) findViewById(R.id.play_one_minute);
        if (mOneMinute!=null){
            mOneMinute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PlayActivity.this, GameActivity.class);
                    intent.putExtra("time", ONE_MINUTE);
                    startActivity(intent);
                }
            });

        }
        Button mTwoMinutes = (Button) findViewById(R.id.play_two_minutes);
        if (mTwoMinutes!=null){
            mTwoMinutes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PlayActivity.this, GameActivity.class);
                    intent.putExtra("time", TWO_MINUTES);
                    startActivity(intent);
                }
            });

        }
        Button mFiveMinutes = (Button) findViewById(R.id.play_five_minutes);
        if (mFiveMinutes!=null){
            mFiveMinutes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PlayActivity.this, GameActivity.class);
                    intent.putExtra("time", FIVE_MINUTES);
                    startActivity(intent);
                }
            });
        }
        final EditText mCustom = (EditText) findViewById(R.id.play_customize);
        if (mCustom != null){
            mCustom.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean handled = false;
                    if (i == EditorInfo.IME_ACTION_DONE) {
                        Intent intent = new Intent(PlayActivity.this, GameActivity.class);
                        System.out.println("CUSTOM INPUT: \t" + textView.getText().toString());
                        double minutes = Double.parseDouble(mCustom.getText().toString());
                        System.out.println("CUSTOMINPUT TWO: \t" + minutes);
                        intent.putExtra("time", (int) (minutes * 1000.0 * 60.0));
                        startActivity(intent);

                        handled = true;
                    }
                    return handled;
                }
            });
        }
        Button mEndless = (Button) findViewById(R.id.play_endless);
        if (mEndless!=null){
            mEndless.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PlayActivity.this, GameActivity.class);
                    intent.putExtra("time", 0);
                    startActivity(intent);
                }
            });
        }
    }
}
