package me.joshuayuan.a163;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JoshuaYuan on 8/19/2016.
 * CardNode should never be empty. Always needs a value.
 */
public class CardNode implements Parcelable{

    private final int NOOP = 0;
    private final int PLUS = 1;
    private final int SUB = 2;
    private final int MULT = 3;
    private final int DIV = 4;

    private CardNode child1; //left
    private CardNode child2; //right
    private int operation; //useful when splitting
    private double value;

    private int position;
    private int cardSlotNumber; //1 2 3 4 5 or 6 represent it's very original slot location.

    public CardNode(double value){ //creating card with only a value EX starting the game
        this.child1 = null;
        this.child2 = null;
        this.value = value;
        this.operation = NOOP;
    }
    public CardNode(CardNode a, CardNode b, int operation){ //creating a new cardnode from 2 w/ operation
        this.child1 = a;
        this.child2 = b;
        this.value = eval(a.getValue(), b.getValue(), operation);
        this.operation = operation;

    }

    public double getValue(){
        return this.value;
    }

    private double eval(double aVal, double bVal, int operation){
        switch (operation){
            case PLUS:
                return aVal + bVal;
            case SUB:
                return aVal - bVal;
            case MULT:
                return aVal * bVal;
            case DIV:
                if(bVal == 0){
                    return Double.MAX_VALUE;
                }
                return aVal/bVal;
            default:
                return this.value;
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {

        String s = "CardNode of value: " + this.value + " @ Qposition: " + this.position + " in slot number " + cardSlotNumber;
        return s;

    }

    public int getCardSlotNumber() {
        return cardSlotNumber;
    }

    public void setCardSlotNumber(int cardSlot) {
        cardSlotNumber = cardSlot;
    }

    public void printNodeTree(){
        traverse(this);
    }
    private void traverse(CardNode cn){
        if (cn == null){
            return;
        } else{
            traverse(cn.child1);
            System.out.println(cn);
            traverse(cn.child2);
        }
    }

    public boolean hasTwoChildren(){
        return child1 != null && child2 != null;
    }

    public CardNode getChild1() {
        return child1;
    }

    public void setChild1(CardNode child1) {
        this.child1 = child1;
    }

    public CardNode getChild2() {
        return child2;
    }

    public void setChild2(CardNode child2) {
        this.child2 = child2;
    }

    public int describeContents(){
        return 0;
    }
    public void writeToParcel(Parcel out, int flags){
        out.writeDouble(value);
        out.writeInt(position);
        out.writeInt(operation);
        out.writeInt(cardSlotNumber);
        out.writeParcelable(child1, 0);
        out.writeParcelable(child2, 0);
    }
    public static final Parcelable.Creator<CardNode> CREATOR = new Parcelable.Creator<CardNode>() {
        public CardNode createFromParcel(Parcel in){
            return new CardNode(in);
        }
        public CardNode[] newArray(int size){
            return new CardNode[size];
        }
    };

    private CardNode(Parcel in){
        value = in.readDouble();
        position = in.readInt();
        operation = in.readInt();
        cardSlotNumber = in.readInt();
        child1 = in.readParcelable(CardNode.class.getClassLoader());
        child2 = in.readParcelable(CardNode.class.getClassLoader());
    }
}
