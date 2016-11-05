package me.joshuayuan.a163;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.LinkedList;

/**
 * Created by JoshuaYuan on 8/22/2016.
 */
public class Queue implements Parcelable {

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
    * index is 1 2 3 4 5 6
     */
    private void decrement(int index){
        // index-1 because linkedlist positions are 0, 1, 2, ... but
        // cardnode position is 1, 2, 3,...
        for(int i = index-1; i < q.size(); i++){
            CardNode c = q.get(i);
            int curr = c.getPosition();
            c.setPosition(curr-1);
        }
    }
    /*
    * index is 1 2 3 4 5 6
     */
    private void increment(int index){
        for (int i = index-1; i < q.size(); i++){
            CardNode c = q.get(i);
            int curr = c.getPosition();
            c.setPosition(curr + 1);
            System.out.println("INCREMENTED <<" +c + ">> from " + curr + " to " + curr+1 );
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
    * when there's only 1 node left in the queue, empty the node.
     */
    public void resetQueue(){
        for (CardNode c : q){
            c.setPosition(0);
            q.clear();
        }
    }

    /*
    * splits the first node of the queue into its resulting nodes.
     */
    public void splitSmall(CardSlot[] cardSlots){
        System.out.println("START");
        CardNode nodeToSplit = q.peekFirst();
        System.out.println("nodeToSplit: \t" + nodeToSplit);
        if (nodeToSplit == null){
            return;
        }
        if (nodeToSplit.hasTwoChildren()){
            q.removeFirst();
            nodeToSplit.setPosition(0);
            CardNode child1 = nodeToSplit.getChild1();
            System.out.println("child1: \t\t" + child1);
            CardNode child2 = nodeToSplit.getChild2();
            System.out.println("child2: \t\t" + child2);
            int firstSlot = child1.getCardSlotNumber();
            int secondSlot = child2.getCardSlotNumber();

            cardSlots[firstSlot-1].setCard(child1);
            cardSlots[secondSlot-1].setCard(child2);

            child1.setPosition(1);
            child2.setPosition(2);
            q.addFirst(child2);
            q.addFirst(child1);
            increment(3); // increments the second and beyond
            System.out.println("nodeToSplit: \t" + nodeToSplit);
            System.out.println("child1: \t\t" + child1);
            System.out.println("child2: \t\t" + child2);
            System.out.println("END");
        }
    }
    public int describeContents(){
        return 0;
    }
    public void writeToParcel(Parcel out, int flags){
        out.writeValue(q);
    }
    public static final Parcelable.Creator<Queue> CREATOR = new Parcelable.Creator<Queue>() {
        public Queue createFromParcel(Parcel in){
            return new Queue(in);
        }
        public Queue[] newArray(int size){
            return new Queue[size];
        }
    };

    private Queue(Parcel in) {
        q = (LinkedList<CardNode>) in.readValue(Queue.class.getClassLoader());
    }
}
