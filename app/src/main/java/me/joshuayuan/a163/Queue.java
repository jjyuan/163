package me.joshuayuan.a163;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.LinkedList;

/**
 * Created by JoshuaYuan on 8/22/2016.
 */
public class Queue implements Parcelable {

    private static LinkedList<CardNode> sQ;
    public Queue(){
        sQ = new LinkedList<>();
    }

    /*
    * Add a CardNode to the queue, and set the position of that CardNode to the size of the new
    * queue.
     */
    public void add(CardNode c){
        sQ.add(c);
        c.setmPosition(sQ.size());
    }
    /*
    * Remove a CardNode from the queue, decrement the position of those behind it by 1, and set its
    * position to 0.
     */
    public void remove(CardNode c){
        sQ.remove(c);
        int index = c.getmPosition();
        decrement(index);
        c.setmPosition(0);
    }
    /*
    * Decrements all the positions of CardNodes after and including index (not 0-based-ordering) by 1 position.
    * index is 1 2 3 4 5 6
     */
    private void decrement(int index){
        // index-1 because linkedlist positions are 0, 1, 2, ... but
        // cardnode position is 1, 2, 3,...
        for(int i = index-1; i < sQ.size(); i++){
            CardNode c = sQ.get(i);
            int curr = c.getmPosition();
            c.setmPosition(curr-1);
        }
    }
    /*
    * index is 1 2 3 4 5 6
     */
    private void increment(int index){
        for (int i = index-1; i < sQ.size(); i++){
            CardNode c = sQ.get(i);
            int curr = c.getmPosition();
            c.setmPosition(curr + 1);
            System.out.println("INCREMENTED <<" +c + ">> from " + curr + " to " + curr+1 );
        }
    }

    /*
    * won't get called if sQ.size < 2
    * returns the Node that will be placed into cardslot of card@queue_pos1
     */
    public CardNode operate(int operation){
        CardNode firstInQ = sQ.poll();
        firstInQ.setmPosition(0);
        int origCardSlot = firstInQ.getCardSlotNumber();
        CardNode secondInQ = sQ.poll();
        secondInQ.setmPosition(0);

        CardNode newNode = new CardNode(firstInQ,secondInQ, operation);
        newNode.setmPosition(1);
        newNode.setCardSlotNumber(origCardSlot);

        sQ.addFirst(newNode);
        decrement(2);
        System.out.println(toString());

        if(sQ.size() < 2){
            resetQueue();
        }

        return newNode;


    }

    @Override
    public String toString() {
        String str = "";
        for(CardNode c : sQ){
            str += c + "\n";
        }
        return str;
    }

    public int getSize(){
        return sQ.size();
    }

    public CardNode getFirstNode(){
        if (sQ.size() < 1){
            return null;
        } else {
            return sQ.peek();
        }
    }
    public CardNode getSecondNode(){
        if (sQ.size() < 2){
            return null;
        } else {
            return sQ.get(1);
        }
    }
    /*
    * when there's only 1 node left in the queue, empty the node.
     */
    public void resetQueue(){
        for (CardNode c : sQ){
            c.setmPosition(0);
            sQ.clear();
        }
    }

    /*
    * splits the first node of the queue into its resulting nodes.
     */
    public void splitSmall(CardSlot[] cardSlots){
        System.out.println("START");
        CardNode nodeToSplit = sQ.peekFirst();
        System.out.println("nodeToSplit: \t" + nodeToSplit);
        if (nodeToSplit == null){
            return;
        }
        if (nodeToSplit.hasTwoChildren()){
            sQ.removeFirst();
            nodeToSplit.setmPosition(0);
            CardNode child1 = nodeToSplit.getmChild1();
            System.out.println("child1: \t\t" + child1);
            CardNode child2 = nodeToSplit.getmChild2();
            System.out.println("child2: \t\t" + child2);
            int firstSlot = child1.getCardSlotNumber();
            int secondSlot = child2.getCardSlotNumber();

            cardSlots[firstSlot-1].setmCard(child1);
            cardSlots[secondSlot-1].setmCard(child2);

            child1.setmPosition(1);
            child2.setmPosition(2);
            sQ.addFirst(child2);
            sQ.addFirst(child1);
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
        out.writeValue(sQ);
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
        sQ = (LinkedList<CardNode>) in.readValue(Queue.class.getClassLoader());
    }
}
