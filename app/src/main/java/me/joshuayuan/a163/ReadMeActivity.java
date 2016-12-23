package me.joshuayuan.a163;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.TextView;

public class ReadMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_me);

        TextView mText = (TextView) findViewById(R.id.readme_text);
        if (mText != null){
            String header = "This is the tutorial/manual for now!\n";
            String goal = "The goal of the game is to use the six numbers (1-13) and perform the" +
                    " four basic mathematical operations to reach the number 163. You must and " +
                    "may only use each number exactly once.\n";
            String body = "1. Press play.\n2. Select a time option, or enter in your own " +
                    "in minutes.\n3. The actual gameplay is a little unintuitive at first --\n";
            String howtoplay = "Select at least 2 cards before you perform the operations " +
                    "(buttons on the bottom of the screen) and then when you select an operator," +
                    " the first two cards in the queue will be operated on.\nWhen you reach 163, " +
                    "select \"=\" to proceed. \"[-/-]\" is the button for undoing pairs.\nHold" +
                    " down the \"=\" button to skip a set for a new six cards.\n";
            String misc = "Please contact me (joshuayuan@berkeley.edu) if you have any questions " +
                    "on what is even going on!\n";
            String thanks = "Thanks for taking the time to download this game! :)";
            String complete = header + goal + body + howtoplay + misc + thanks;

            SpannableString ss = new SpannableString(complete);
            StyleSpan bold = new StyleSpan(Typeface.BOLD);
            StyleSpan italic = new StyleSpan(Typeface.ITALIC);
            RelativeSizeSpan title = new RelativeSizeSpan(2f);
            ss.setSpan(new RelativeSizeSpan(2f), 0, 36, 0);
            ss.setSpan(new StyleSpan(Typeface.BOLD), 0,36,0);
            ss.setSpan(new StyleSpan(Typeface.BOLD), 162, 165, 0);
            ss.setSpan(new StyleSpan(Typeface.BOLD), 219, 221, 0);
            ss.setSpan(new StyleSpan(Typeface.BOLD), 233, 236, 0);
            ss.setSpan(new StyleSpan(Typeface.BOLD), 291, 294, 0);
            ss.setSpan(new StyleSpan(Typeface.ITALIC), 701, 726, 0);

//            System.out.println(complete);
//            Log.d("character: 161", Character.toString(ss.charAt(161)));
//            Log.d("character: 162", Character.toString(ss.charAt(162)));
//            Log.d("character: 163", Character.toString(ss.charAt(163)));
            mText.setText(ss);
            mText.setMovementMethod(new ScrollingMovementMethod());

        }


    }
}
