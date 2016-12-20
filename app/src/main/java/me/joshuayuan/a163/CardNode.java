package me.joshuayuan.a163;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JoshuaYuan on 8/19/2016.
 * CardNode should never be empty. Always needs a mValue.
 */
public class CardNode implements Parcelable{

    public static final int NOOP = 0;
    public static final int PLUS = 1;
    public static final int SUB = 2;
    public static final int MULT = 3;
    public static final int DIV = 4;

    private CardNode mChild1; //left
    private CardNode mChild2; //right
    private int mOperation; //useful when splitting
    private double mValue;

    private int mPosition;
    private int cardSlotNumber; //1 2 3 4 5 or 6 represent it's very original slot location.

    public CardNode(double value){ //creating card with only a mValue EX starting the game
        this.mChild1 = null;
        this.mChild2 = null;
        this.mValue = value;
        this.mOperation = NOOP;
    }
    public CardNode(CardNode a, CardNode b, int operation){ //creating a new cardnode from 2 w/ mOperation
        this.mChild1 = a;
        this.mChild2 = b;
        this.mValue = eval(a.getmValue(), b.getmValue(), operation);
        this.mOperation = operation;

    }

    public double getmValue(){
        return this.mValue;
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
                return this.mValue;
        }
    }

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    @Override
    public String toString() {

        String s = "CardNode of mValue: " + this.mValue + " @ Qposition: " + this.mPosition + " in slot number " + cardSlotNumber;
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
            traverse(cn.mChild1);
            System.out.println(cn);
            traverse(cn.mChild2);
        }
    }

    public boolean hasTwoChildren(){
        return mChild1 != null && mChild2 != null;
    }

    public CardNode getmChild1() {
        return mChild1;
    }

    public void setmChild1(CardNode mChild1) {
        this.mChild1 = mChild1;
    }

    public CardNode getmChild2() {
        return mChild2;
    }

    public void setmChild2(CardNode mChild2) {
        this.mChild2 = mChild2;
    }

    public int describeContents(){
        return 0;
    }
    public void writeToParcel(Parcel out, int flags){
        out.writeDouble(mValue);
        out.writeInt(mPosition);
        out.writeInt(mOperation);
        out.writeInt(cardSlotNumber);
        out.writeParcelable(mChild1, 0);
        out.writeParcelable(mChild2, 0);
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
        mValue = in.readDouble();
        mPosition = in.readInt();
        mOperation = in.readInt();
        cardSlotNumber = in.readInt();
        mChild1 = in.readParcelable(CardNode.class.getClassLoader());
        mChild2 = in.readParcelable(CardNode.class.getClassLoader());
    }
}
