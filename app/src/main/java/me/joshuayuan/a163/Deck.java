package me.joshuayuan.a163;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Joshua Yuan on 11/6/2016.
 */
public class Deck {
    private Random rand;
    private static ArrayList<Integer> deck;
    private int batches;

    public Deck(){
        rand = new Random();
        deck = new ArrayList<>();
        newDeck();

    }

    public ArrayList<Integer> drawSix(){
        if (batches > 3){
            newDeck();
        }
        batches++;
        ArrayList<Integer> batch = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            int pos = rand.nextInt(deck.size());
            batch.add(deck.get(pos));
            deck.remove(pos);
            System.out.println(toString());
        }
        return batch;
    }

    private void newDeck(){
        deck.clear();
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= 13; j++){
                deck.add(j);
            }
        }
        batches = 0;
    }

    @Override
    public String toString(){
        String res = "";
        for (int i = 0; i < deck.size(); i++){
            if (i%13 == 0){
                res+="\n";
            }
            res += deck.get(i) + " ";
        }
        return res;
    }
}
