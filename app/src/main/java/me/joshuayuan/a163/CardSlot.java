package me.joshuayuan.a163;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by JoshuaYuan on 8/17/2016.
 */
public class CardSlot extends Button {
    private CardNode card;


    public CardSlot(Context context, AttributeSet attrs){
        super(context, attrs);
        this.card = null;
    }

    @Override
    public boolean isClickable() {
        if(this.card == null){
            return false;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Bitmap bm = Bitmap.createBitmap()


        super.onDraw(canvas);

    }

    @Override
    public void setText(CharSequence text, BufferType type) {

        super.setText(text, type);
        System.out.println("text is " + text.toString());
    }

    public CardNode getCard() {
        return card;
    }

    public void setCard(CardNode card) {
        this.card = card;
    }

    private Bitmap queuedBM(){
        int p = this.card.getPosition();
        switch (p){
            case 1:
                return BitmapFactory.decodeResource(this.context.getResources())
        }
    }
}
