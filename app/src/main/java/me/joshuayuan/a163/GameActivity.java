package me.joshuayuan.a163;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private final boolean PRACTICE_MODE = true;
    private final boolean SPEED_MODE = false;
    private boolean gameMode;
    Random rand = new Random();

    private CardSlot cardSlot1;
    private CardSlot cardSlot2;
    private CardSlot cardSlot3;
    private CardSlot cardSlot4;
    private CardSlot cardSlot5;
    private CardSlot cardSlot6;
    private View[] slotViews = new View[6];
    private CardSlot[] cardSlots = new CardSlot[6];

    private Queue theQ;

    private Button opPLUS;
    private Button opSUB;
    private Button opMULT;
    private Button opDIV;

    private final int PLUS = 1;
    private final int SUB = 2;
    private final int MULT = 3;
    private final int DIV = 4;

    private Button splitButton;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        Intent intent = getIntent();
        gameMode = intent.getBooleanExtra("gameMode", PRACTICE_MODE);

        slotViews[0] = findViewById(R.id.card_slot_1);
        cardSlot1 = (CardSlot) slotViews[0];
        if(cardSlot1!=null){

            cardSlot1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot1.getCard();
                    if (c == null){
                        return;
                    }
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);
                    reDrawSlots();

                }
            });
        }
        slotViews[1] = findViewById(R.id.card_slot_2);
        cardSlot2 = (CardSlot) slotViews[1];
        if(cardSlot2!=null){

            cardSlot2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot2.getCard();
                    if (c == null){
                        return;
                    }
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);
                    reDrawSlots();

                }
            });
        }
        slotViews[2] = findViewById(R.id.card_slot_3);
        cardSlot3 = (CardSlot) slotViews[2];
        if(cardSlot3!=null){

            cardSlot3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot3.getCard();
                    if (c == null){
                        return;
                    }
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);
                    reDrawSlots();

                }
            });
        }
        slotViews[3] = findViewById(R.id.card_slot_4);
        cardSlot4 = (CardSlot) slotViews[3];
        if(cardSlot4!=null){

            cardSlot4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot4.getCard();
                    if (c == null){
                        return;
                    }
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);
                    reDrawSlots();

                }
            });
        }
        slotViews[4] = findViewById(R.id.card_slot_5);
        cardSlot5 = (CardSlot) slotViews[4];
        if(cardSlot5!=null){

            cardSlot5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot5.getCard();
                    if (c == null){
                        return;
                    }
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);
                    reDrawSlots();

                }
            });
        }
        slotViews[5] = findViewById(R.id.card_slot_6);
        cardSlot6 = (CardSlot) slotViews[5];
        if(cardSlot6!=null){

            cardSlot6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot6.getCard();
                    if (c == null){
                        return;
                    }
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);
                    reDrawSlots();

                }
            });
        }

        opPLUS = (Button) findViewById(R.id.plus_button);
        if (opPLUS != null) {
            opPLUS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("BEFORE ANYTHING: " + theQ);
                    if( theQ.getSize() >= 2){

                        int firstSlotNumber = theQ.getFirstNode().getCardSlotNumber();
                        int secondSlotNumber = theQ.getSecondNode().getCardSlotNumber();
                        clearTwoSlots(firstSlotNumber, secondSlotNumber);

                        CardNode newNode = theQ.operate(PLUS);
                        getCardSlot(firstSlotNumber).setCard(newNode);
                        reDrawSlots();
                        relabel();
                    }
                    System.out.println("AFTER EVERYTHING: " + theQ);
                }
            });
        }

        opSUB = (Button) findViewById(R.id.sub_button);
        if (opSUB != null) {
            opSUB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(theQ.getSize() >= 2){

                        int firstSlotNumber = theQ.getFirstNode().getCardSlotNumber();
                        int secondSlotNumber = theQ.getSecondNode().getCardSlotNumber();
                        clearTwoSlots(firstSlotNumber, secondSlotNumber);

                        CardNode newNode = theQ.operate(SUB);
                        getCardSlot(firstSlotNumber).setCard(newNode);
                        reDrawSlots();
                        relabel();
                    }
                }
            });
        }

        opMULT = (Button) findViewById(R.id.mult_button);
        if (opMULT != null) {
            opMULT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(theQ.getSize() >= 2){

                        int firstSlotNumber = theQ.getFirstNode().getCardSlotNumber();
                        int secondSlotNumber = theQ.getSecondNode().getCardSlotNumber();
                        clearTwoSlots(firstSlotNumber, secondSlotNumber);

                        CardNode newNode = theQ.operate(MULT);
                        getCardSlot(firstSlotNumber).setCard(newNode);
                        reDrawSlots();
                        relabel();
                    }
                }
            });
        }

        opDIV = (Button) findViewById(R.id.div_button);
        if (opDIV != null) {
            opDIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(theQ.getSize() >= 2){
                        int firstSlotNumber = theQ.getFirstNode().getCardSlotNumber();
                        int secondSlotNumber = theQ.getSecondNode().getCardSlotNumber();
                        clearTwoSlots(firstSlotNumber, secondSlotNumber);

                        CardNode newNode = theQ.operate(DIV);
                        getCardSlot(firstSlotNumber).setCard(newNode);
                        reDrawSlots();
                        relabel();
                    }
                }
            });
        }

        splitButton = (Button) findViewById(R.id.split_button);
        if (splitButton != null){
            splitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    CardNode last = getLastNode();
//                    if ( last != null){
//                        last.printNodeTree();
//                    }
                    if (theQ.getSize() >= 1){ // if theres even a queue
                        theQ.splitSmall(cardSlots);
                        relabel();
                        reDrawSlots();
                    }
                    System.out.println("*** HERE WE GO ***" + theQ);


                }
            });
        }

        submitButton = (Button) findViewById(R.id.submit_button);
        if (submitButton != null){
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getLastNode()!=null && getLastNode().getValue() == 163) {
                        flash(0);
                        newCards();
                        reDrawSlots();
                    } else {
                        flash(1);
                    }
                }
            });
            submitButton.setOnTouchListener(new View.OnTouchListener() {
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
                                theQ.resetQueue();

                            } else {
                                if (getLastNode()!=null && getLastNode().getValue() == 163) {
                                    flash(0);
                                    newCards();
                                    reDrawSlots();
                                    theQ.resetQueue();

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
        cardSlots[0] = cardSlot1;
        cardSlots[1] = cardSlot2;
        cardSlots[2] = cardSlot3;
        cardSlots[3] = cardSlot4;
        cardSlots[4] = cardSlot5;
        cardSlots[5] = cardSlot6;
        theQ = new Queue();
    }
    private void newCards(){
        //put random numbers
        for(int i = 0; i < cardSlots.length; i++){
            double num = rand.nextInt(13)+1;
            CardNode node = new CardNode(num);
            node.setCardSlotNumber(i+1);
            cardSlots[i].setCard(node);

            String s = Double.toString(num);
            if ( num%1 == 0){
                s = Integer.toString((int) num);
            }

            cardSlots[i].setText(s);
            System.out.println("num is " + num);
//            cardSlots[i].setText(Integer.toString(num));
//            cardSlots[i].setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.card_text_size));
        }

        //create nodes with random values.

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        for (int i = 0; i < cardSlots.length; i++) {
            outState.putParcelable("cardslot" + (i+1), cardSlots[i].getCard());
        }
        outState.putParcelable("q", theQ);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        for (int i = 0; i < cardSlots.length; i++){
            cardSlots[i].setCard( (CardNode) savedInstanceState.getParcelable("cardslot" +(i+1)));
        }
        theQ = savedInstanceState.getParcelable("q");
        System.out.println("HERE WE GO BOYS");
    }

    private void reDrawSlots(){
        for(View v: slotViews){
            v.invalidate();
        }
    }

    /*
    * int ind should be 1 2 3 4 5 or 6.
     */
    private CardSlot getCardSlot(int ind){
        return cardSlots[ind-1];
    }

    /*
    * clears the two slots of that card node (so that the new node can be placed into the first cardslot)
     */
    private void clearTwoSlots(int slotA, int slotB){
        getCardSlot(slotA).setCard(null);
        getCardSlot(slotB).setCard(null);
    }


    private void relabel(){
        for (CardSlot c : cardSlots){
            if (c.getCard() != null){
                double v = c.getCard().getValue();
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
        for (CardSlot c : cardSlots){
            if ( c.getCard() != null){
                count++;
                keep = c.getCard();
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

}
