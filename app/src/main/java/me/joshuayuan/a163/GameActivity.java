package me.joshuayuan.a163;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private final boolean PRACTICE_MODE = true;
    private final boolean SPEED_MODE = false;
    private boolean gameMode;

    private CardSlot mCardSlot1;
    private CardSlot mCardSlot2;
    private CardSlot mCardSlot3;
    private CardSlot mCardSlot4;
    private CardSlot mCardSlot5;
    private CardSlot mCardSlot6;
    private View[] mSlotViews = new View[6];
    private CardSlot[] mCardSlots = new CardSlot[6];

    private Queue mTheQ;
    private Deck mDeck;
    private Timer mTimer;
    private int mScore;

    private Button mOpPLUS;
    private Button mOpSUB;
    private Button mOpMULT;
    private Button mOpDIV;
    private Button mSplitButton;
    private Button mSubmitButton;

    public static final int PLUS = 1;
    public static final int SUB = 2;
    public static final int MULT = 3;
    public static final int DIV = 4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        mScore = 0;
        int timeLimit = 0;
        Intent prevIntent = getIntent();
        timeLimit = prevIntent.getIntExtra("time", timeLimit);
        System.out.println("RECEIVED TIME: \t" + timeLimit);

        if (timeLimit != 0) {
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(GameActivity.this, ScoreScreenActivity.class);
                    System.out.println("game: " + mScore);
                    intent.putExtra("mScore", mScore);
                    startActivity(intent);
                    finish();
                }
            }, timeLimit);
        }

        mSlotViews[0] = findViewById(R.id.card_slot_1);
        mCardSlot1 = (CardSlot) mSlotViews[0];
        if(mCardSlot1 !=null){

            mCardSlot1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = mCardSlot1.getmCard();
                    if (c == null){
                        return;
                    }
                    if (c.getmPosition() == 0){
                        mTheQ.add(c);
                    } else {
                        mTheQ.remove(c);
                    }
                    System.out.println(mTheQ);
                    reDrawSlots();

                }
            });
        }
        mSlotViews[1] = findViewById(R.id.card_slot_2);
        mCardSlot2 = (CardSlot) mSlotViews[1];
        if(mCardSlot2 !=null){

            mCardSlot2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = mCardSlot2.getmCard();
                    if (c == null){
                        return;
                    }
                    if (c.getmPosition() == 0){
                        mTheQ.add(c);
                    } else {
                        mTheQ.remove(c);
                    }
                    System.out.println(mTheQ);
                    reDrawSlots();

                }
            });
        }
        mSlotViews[2] = findViewById(R.id.card_slot_3);
        mCardSlot3 = (CardSlot) mSlotViews[2];
        if(mCardSlot3 !=null){

            mCardSlot3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = mCardSlot3.getmCard();
                    if (c == null){
                        return;
                    }
                    if (c.getmPosition() == 0){
                        mTheQ.add(c);
                    } else {
                        mTheQ.remove(c);
                    }
                    System.out.println(mTheQ);
                    reDrawSlots();

                }
            });
        }
        mSlotViews[3] = findViewById(R.id.card_slot_4);
        mCardSlot4 = (CardSlot) mSlotViews[3];
        if(mCardSlot4 !=null){

            mCardSlot4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = mCardSlot4.getmCard();
                    if (c == null){
                        return;
                    }
                    if (c.getmPosition() == 0){
                        mTheQ.add(c);
                    } else {
                        mTheQ.remove(c);
                    }
                    System.out.println(mTheQ);
                    reDrawSlots();

                }
            });
        }
        mSlotViews[4] = findViewById(R.id.card_slot_5);
        mCardSlot5 = (CardSlot) mSlotViews[4];
        if(mCardSlot5 !=null){

            mCardSlot5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = mCardSlot5.getmCard();
                    if (c == null){
                        return;
                    }
                    if (c.getmPosition() == 0){
                        mTheQ.add(c);
                    } else {
                        mTheQ.remove(c);
                    }
                    System.out.println(mTheQ);
                    reDrawSlots();

                }
            });
        }
        mSlotViews[5] = findViewById(R.id.card_slot_6);
        mCardSlot6 = (CardSlot) mSlotViews[5];
        if(mCardSlot6 !=null){

            mCardSlot6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = mCardSlot6.getmCard();
                    if (c == null){
                        return;
                    }
                    if (c.getmPosition() == 0){
                        mTheQ.add(c);
                    } else {
                        mTheQ.remove(c);
                    }
                    System.out.println(mTheQ);
                    reDrawSlots();

                }
            });
        }

        mOpPLUS = (Button) findViewById(R.id.plus_button);
        if (mOpPLUS != null) {
            mOpPLUS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("BEFORE ANYTHING: " + mTheQ);
                    if( mTheQ.getSize() >= 2){

                        int firstSlotNumber = mTheQ.getFirstNode().getCardSlotNumber();
                        int secondSlotNumber = mTheQ.getSecondNode().getCardSlotNumber();
                        clearTwoSlots(firstSlotNumber, secondSlotNumber);

                        CardNode newNode = mTheQ.operate(PLUS);
                        getCardSlot(firstSlotNumber).setmCard(newNode);
                        reDrawSlots();
                        relabel();
                    }
                    System.out.println("AFTER EVERYTHING: " + mTheQ);
                }
            });
        }

        mOpSUB = (Button) findViewById(R.id.sub_button);
        if (mOpSUB != null) {
            mOpSUB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mTheQ.getSize() >= 2){

                        int firstSlotNumber = mTheQ.getFirstNode().getCardSlotNumber();
                        int secondSlotNumber = mTheQ.getSecondNode().getCardSlotNumber();
                        clearTwoSlots(firstSlotNumber, secondSlotNumber);

                        CardNode newNode = mTheQ.operate(SUB);
                        getCardSlot(firstSlotNumber).setmCard(newNode);
                        reDrawSlots();
                        relabel();
                    }
                }
            });
        }

        mOpMULT = (Button) findViewById(R.id.mult_button);
        if (mOpMULT != null) {
            mOpMULT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mTheQ.getSize() >= 2){

                        int firstSlotNumber = mTheQ.getFirstNode().getCardSlotNumber();
                        int secondSlotNumber = mTheQ.getSecondNode().getCardSlotNumber();
                        clearTwoSlots(firstSlotNumber, secondSlotNumber);

                        CardNode newNode = mTheQ.operate(MULT);
                        getCardSlot(firstSlotNumber).setmCard(newNode);
                        reDrawSlots();
                        relabel();
                    }
                }
            });
        }

        mOpDIV = (Button) findViewById(R.id.div_button);
        if (mOpDIV != null) {
            mOpDIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mTheQ.getSize() >= 2){
                        int firstSlotNumber = mTheQ.getFirstNode().getCardSlotNumber();
                        int secondSlotNumber = mTheQ.getSecondNode().getCardSlotNumber();
                        clearTwoSlots(firstSlotNumber, secondSlotNumber);

                        CardNode newNode = mTheQ.operate(DIV);
                        getCardSlot(firstSlotNumber).setmCard(newNode);
                        reDrawSlots();
                        relabel();
                    }
                }
            });
        }

        mSplitButton = (Button) findViewById(R.id.split_button);
        if (mSplitButton != null){
            mSplitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    CardNode last = getLastNode();
//                    if ( last != null){
//                        last.printNodeTree();
//                    }
                    if (mTheQ.getSize() >= 1){ // if theres even a queue
                        mTheQ.splitSmall(mCardSlots);
                        relabel();
                        reDrawSlots();
                    }
                    System.out.println("*** HERE WE GO ***" + mTheQ);


                }
            });
        }

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        if (mSubmitButton != null){

            mSubmitButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch(motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            return true;
                        case MotionEvent.ACTION_UP:
                            Long timing = motionEvent.getEventTime() - motionEvent.getDownTime();
                            System.out.println("TIME RELAPSED: " + timing);
                            if ( timing > 500) {
                                flash(2);
                                newCards();
                                reDrawSlots();
                                mTheQ.resetQueue();

                            } else {
                                if (getLastNode()!=null && getLastNode().getmValue() == 163) {
                                    mScore++;
                                    flash(0);
                                    newCards();
                                    reDrawSlots();
                                    mTheQ.resetQueue();

                                } else {
                                    flash(1);
                                }
                            }
                            return false;
                        default:
                            return true;
                    }
                }
            });
        }

        initialize();
        newCards();


    }
    private void initialize(){
        mCardSlots[0] = mCardSlot1;
        mCardSlots[1] = mCardSlot2;
        mCardSlots[2] = mCardSlot3;
        mCardSlots[3] = mCardSlot4;
        mCardSlots[4] = mCardSlot5;
        mCardSlots[5] = mCardSlot6;
        mTheQ = new Queue();
        mDeck = new Deck();
    }
    private void newCards(){
        //put random numbers
        ArrayList<Integer> batch = mDeck.drawSix();
        System.out.print("batch is ");
        for(int i = 0; i < batch.size(); i++){
            System.out.print(batch.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            int num = batch.get(i);

            CardNode node = new CardNode(num);
            node.setCardSlotNumber(i + 1);
            mCardSlots[i].setmCard(node);

            String s = Double.toString(num);
            if (num % 1 == 0) {
                s = Integer.toString((int) num);
            }

            mCardSlots[i].setText(s);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        for (int i = 0; i < mCardSlots.length; i++) {
            outState.putParcelable("cardslot" + (i+1), mCardSlots[i].getmCard());
        }
        outState.putParcelable("q", mTheQ);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        for (int i = 0; i < mCardSlots.length; i++){
            mCardSlots[i].setmCard( (CardNode) savedInstanceState.getParcelable("cardslot" +(i+1)));
        }
        mTheQ = savedInstanceState.getParcelable("q");
        System.out.println("HERE WE GO BOYS");
    }

    private void reDrawSlots(){
        for(View v: mSlotViews){
            v.invalidate();
        }
    }

    /*
    * int ind should be 1 2 3 4 5 or 6.
     */
    private CardSlot getCardSlot(int ind){
        return mCardSlots[ind-1];
    }

    /*
    * clears the two slots of that card node (so that the new node can be placed into the first cardslot)
     */
    private void clearTwoSlots(int slotA, int slotB){
        getCardSlot(slotA).setmCard(null);
        getCardSlot(slotB).setmCard(null);
    }


    private void relabel(){
        for (CardSlot c : mCardSlots){
            if (c.getmCard() != null){
                double v = c.getmCard().getmValue();
                String s = Double.toString(v);
                if ( v%1 == 0){
                    s = String.format("%d", (int) v);
                }
                c.setText(s);
            } else{

                c.setText("");
            }

        }
    }

    private CardNode getLastNode(){
        CardNode keep = null;
        int count = 0;
        for (CardSlot c : mCardSlots){
            if ( c.getmCard() != null){
                count++;
                keep = c.getmCard();
            }
        }
        if (count==1){
            return keep;
        } else{
            return null;
        }
    }


    private void flash(int option){
        LinearLayout background = (LinearLayout) findViewById(R.id.father_layout);
        if (background!= null){

            switch (option){

                case 0:
                    background.setBackgroundResource(R.drawable.complete);
                    break;
                case 1:
                    background.setBackgroundResource(R.drawable.incomplete);
                    break;
                case 2:
                    background.setBackgroundResource(R.drawable.refresh);
                    break;
                default:
                    break;
            }
            TransitionDrawable td = (TransitionDrawable) background.getBackground();
            td.startTransition(10);
            td.reverseTransition(500);
        }
    }

    // Copy & Pasted from another StackOverFlow (http://stackoverflow.com/questions/16646301/onbackpressed-is-not-being-called)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        System.out.println("BACK BUTTON PRESSED!!! GAMEACTIVITY");
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.d("back", "should go back to PlayActivity");
            if (mTimer!= null){

                mTimer.cancel();
            }
            Intent i=new Intent(GameActivity.this, PlayActivity.class);
            startActivity(i);
            finish();
        }
        return true;
    }

}
