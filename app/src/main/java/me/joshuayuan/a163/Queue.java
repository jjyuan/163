package me.joshuayuan.a163;

import java.util.LinkedList;

/**
 * Created by JoshuaYuan on 8/22/2016.
 */
public class Queue {

    private static LinkedList<CardNode> q;
    public Queue(){
        q = new LinkedList<>();
    }

    /*
    * Add a CardNode to the queue, and set the position of that CardNode to the size of the new
    * queue.
     */
    public void add(CardNode c){
        q.add(c);
        c.setPosition(q.size());
    }
    /*
    * Remove a CardNode from the queue, decrement the position of those behind it by 1, and set its
    * position to 0.
     */
    public void remove(CardNode c){
        q.remove(c);
        int index = c.getPosition();
        decrement(index);
        c.setPosition(0);
    }
    /*
    * Decrements all the positions of CardNodes after and including index (not 0-based-ordering) by 1 position.
     */
    private void decrement(int index){
        // index-1 because linkedlist positions are 0, 1, 2, ... but
        // cardnode position is 1, 2, 3,...
        for(int i = index-1; i < q.size(); i++){
            int curr = q.get(i).getPosition();
            q.get(i).setPosition(curr-1);
        }
    }

    /*
    * won't get called if q.size < 2
    * returns the Node that will be placed into cardslot of card@queue_pos1
     */
    public CardNode operate(int operation){
        CardNode firstInQ = q.poll();
        firstInQ.setPosition(0);
        int origCardSlot = firstInQ.getCardSlotNumber();
        CardNode secondInQ = q.poll();
        secondInQ.setPosition(0);

        CardNode newNode = new CardNode(firstInQ,secondInQ, operation);
        newNode.setPosition(1);
        newNode.setCardSlotNumber(origCardSlot);

        q.addFirst(newNode);
        decrement(2);
        System.out.println(toString());

        if(q.size() < 2){
            resetQueue();
        }

        return newNode;


    }

    @Override
    public String toString() {
        String str = "";
        for(CardNode c : q ){
            str += c + "\n";
        }
        return str;
    }

    public int getSize(){
        return q.size();
    }

    public CardNode getFirstNode(){
        if (q.size() < 1){
            return null;
        } else {
            return q.peek();
        }
    }
    public CardNode getSecondNode(){
        if (q.size() < 2){
            return null;
        } else {
            return q.get(1);
        }
    }
    /*
    *
     */
    private void resetQueue(){
        for (CardNode c : q){
            c.setPosition(0);
            q.clear();
        }
    }
}
