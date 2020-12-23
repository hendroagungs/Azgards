package com.example.android.azgards;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.jar.Attributes;
import android.os.Handler;
import java.util.logging.LogRecord;

public class TypeWritter extends android.support.v7.widget.AppCompatTextView {
    private CharSequence mText;
    private int mIndex;
    private long mDelay = 150;

    public TypeWritter(Context context){
        super(context);
    }

    public TypeWritter(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    private Handler mHandler = new Handler();

    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0,mIndex++));

            if(mIndex < mText.length()){
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void animateText(CharSequence txt){
        mText = txt;
        mIndex= 0;

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long m){
        mDelay= m;
    }
}
