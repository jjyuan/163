package me.joshuayuan.a163;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by JoshuaYuan on 8/17/2016.
 */
public class CardSlot extends Button{
    private CardNode mCard;
    private Context mContext;


    public CardSlot(Context context, AttributeSet attrs){
        super(context, attrs);
        this.mContext = context;
        this.mCard = null;
    }

    @Override
    public boolean isClickable() {
        if(this.mCard == null){
            return false;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (mCard !=null && mCard.getPosition()!=0){
//            System.out.print("redrawing mCard " + mCard.getmValue() + " to queue ");
            Bitmap bm = queuedBM();
            if ( bm!= null) {
                canvas.drawBitmap(bm, 15, 15, null);
            }
        }
        super.onDraw(canvas);

    }

    @Override
    public void setText(CharSequence text, BufferType type) {

        System.out.println(text + " is the string and it is " + text.length() +" long");
        if ( text.length() > 6) {
            text = text.subSequence(0, 5) + "...";
        }
        super.setText(text, type);
//        System.out.println("text is " + text.toString());
    }

    public CardNode getmCard() {
        return mCard;
    }

    public void setmCard(CardNode mCard) {
        this.mCard = mCard;
    }

    private Bitmap queuedBM(){
        int p = this.mCard.getPosition();
        System.out.println(p);
        switch (p){
            case 1:
                return BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.queue1);
            case 2:
                return BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.queue2);
            case 3:
                return BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.queue3);
            case 4:
                return BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.queue4);
            case 5:
                return BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.queue5);
            case 6:
                return BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.queue6);
            default:
                return null;
        }
    }
    /*
    public int describeContents(){
        return 0;
    }
    public void writeToParcel(Parcel out, int flags){
        out.writeParcelable(mCard, 0);
        out.writeValue(mContext);
    }
    public static final Parcelable.Creator<CardSlot> CREATOR = new Parcelable.Creator<CardSlot>() {
        public CardSlot createFromParcel(Parcel in){
            return new CardSlot(in);
        }
        public CardSlot[] newArray(int size){
            return new CardSlot[size];
        }
    };

    protected CardSlot(Parcel in){
        mCard = in.readParcelable(CardNode.class.getClassLoader());
        mContext = (Context) in.readValue(Context.class.getClassLoader());
    }
*/
    /*@Override
    public Parcelable onSaveInstanceState(){
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putParcelable("cardnode", this.mCard); // ... save stuff
        mContext = getContext();
        return bundle;
    }
    @Override
    public void onRestoreInstanceState(Parcelable state){
        if (state instanceof Bundle) // implicit null check
        {
            Bundle bundle = (Bundle) state;
            this.mCard = bundle.getParcelable("cardnode"); // ... load stuff
            state = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(state);

    }*/


}
