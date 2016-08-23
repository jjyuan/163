package me.joshuayuan.a163;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import java.util.LinkedList;

/**
 * Created by JoshuaYuan on 8/17/2016.
 */
public class CardHolder extends Button{

    public static LinkedList<CardNode> queue;

    public CardHolder(Context context, AttributeSet attrs){
        super(context, attrs);
        //initialize all 6 cardholders

        queue = new LinkedList<>();
    }
}
