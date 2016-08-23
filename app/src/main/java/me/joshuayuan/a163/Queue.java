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
    * Decrements all the positions of CardNodes after index by 1.
     */
    private void decrement(int index){
        for(int i = index-1; i < q.size(); i++){
            int curr = q.get(i).getPosition();
            q.get(i).setPosition(curr-1);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for(CardNode c : q ){
            double v = c.getValue();
            str += "value: " + Double.toString(v) + " position: " + c.getPosition() + "\n";
        }
        return str;
    }
}
