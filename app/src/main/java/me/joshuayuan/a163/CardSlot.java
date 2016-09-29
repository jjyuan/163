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
    private Context context;


    public CardSlot(Context context, AttributeSet attrs){
        super(context, attrs);
        this.context = context;
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

        if (card!=null && card.getPosition()!=0){
//            System.out.print("redrawing card " + card.getValue() + " to queue ");
            Bitmap bm = queuedBM();
            if ( bm!= null) {
                canvas.drawBitmap(bm, 20, 20, null);
            }
        }
        super.onDraw(canvas);

    }

    @Override
    public void setText(CharSequence text, BufferType type) {

        System.out.println(text + " is the string and it is " + text.length() +" long");
        if ( text.length() > 6) {
            text = text.subSequence(0, 6) + "...";
        }
        super.setText(text, type);
//        System.out.println("text is " + text.toString());
    }

    public CardNode getCard() {
        return card;
    }

    public void setCard(CardNode card) {
        this.card = card;
    }

    private Bitmap queuedBM(){
        int p = this.card.getPosition();
        System.out.println(p);
        switch (p){
            case 1:
                return BitmapFactory.decodeResource(this.context.getResources(), R.drawable.queue1);
            case 2:
                return BitmapFactory.decodeResource(this.context.getResources(), R.drawable.queue2);
            case 3:
                return BitmapFactory.decodeResource(this.context.getResources(), R.drawable.queue3);
            case 4:
                return BitmapFactory.decodeResource(this.context.getResources(), R.drawable.queue4);
            case 5:
                return BitmapFactory.decodeResource(this.context.getResources(), R.drawable.queue5);
            case 6:
                return BitmapFactory.decodeResource(this.context.getResources(), R.drawable.queue6);
            default:
                return null;
        }
    }
}
