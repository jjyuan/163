package me.joshuayuan.a163;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
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
    CardSlot[] cardSlots = new CardSlot[6];

    private Queue theQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        gameMode = intent.getBooleanExtra("gameMode", PRACTICE_MODE);
        cardSlot1 = (CardSlot) findViewById(R.id.card_slot_1);
        if(cardSlot1!=null){

            cardSlot1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot1.getCard();
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);

                }
            });
        }
        cardSlot2 = (CardSlot) findViewById(R.id.card_slot_2);
        if(cardSlot2!=null){

            cardSlot2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot2.getCard();
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);

                }
            });
        }
        cardSlot3 = (CardSlot) findViewById(R.id.card_slot_3);
        if(cardSlot3!=null){

            cardSlot3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot3.getCard();
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);

                }
            });
        }
        cardSlot4 = (CardSlot) findViewById(R.id.card_slot_4);
        if(cardSlot4!=null){

            cardSlot4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot4.getCard();
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);

                }
            });
        }
        cardSlot5 = (CardSlot) findViewById(R.id.card_slot_5);
        if(cardSlot5!=null){

            cardSlot5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot5.getCard();
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);

                }
            });
        }
        cardSlot6 = (CardSlot) findViewById(R.id.card_slot_6);
        if(cardSlot6!=null){

            cardSlot6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardNode c = cardSlot6.getCard();
                    if (c.getPosition() == 0){
                        theQ.add(c);
                    } else {
                        theQ.remove(c);
                    }
                    System.out.println(theQ);

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
            cardSlots[i].setCard(node);
            cardSlots[i].setText(Double.toString(num));
            System.out.println("num is " + num);
//            cardSlots[i].setText(Integer.toString(num));
//            cardSlots[i].setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.card_text_size));
        }

        //create nodes with random values.

    }

    private void relabel(){
        return;

    }



}
