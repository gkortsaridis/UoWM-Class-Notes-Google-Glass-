package com.gkortsaridis.uowm_classnotes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;

public class SlidesActivity extends Activity {

    private ImageView imageView;
    private TextView textView;
    private GestureDetector mGestureDetector;
    private int position = 0;

    private int[] imagesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slides);

        imagesArray = new int[] {
                R.drawable.asl1_001,
                R.drawable.asl1_002,
                R.drawable.asl1_003,
                R.drawable.asl1_004,
                R.drawable.asl1_005,
                R.drawable.asl1_006,
                R.drawable.asl1_007,
                R.drawable.asl1_008,
                R.drawable.asl1_009,
                R.drawable.asl1_010,
                R.drawable.asl1_011,
                R.drawable.asl1_012,
                R.drawable.asl1_013,
                R.drawable.asl1_014,
                R.drawable.asl1_015
        };


        imageView = (ImageView) findViewById(R.id.slide_image);
        textView = (TextView) findViewById(R.id.slide_num);

        setImage(position);
        mGestureDetector = createGestureDetector(this);
    }

    private void setImage(int position){
        Log.i("Setting",position+"");
        imageView.setImageResource(imagesArray[position]);
        textView.setText((position+1)+"/"+imagesArray.length);
    }

    private GestureDetector createGestureDetector(Context context) {
        GestureDetector gestureDetector = new GestureDetector(context);
        //Create a base listener for generic gestures
        gestureDetector.setBaseListener( new GestureDetector.BaseListener() {
            @Override
            public boolean onGesture(Gesture gesture) {
                if (gesture == Gesture.TAP) {
                    // do something on tap
                    return true;
                } else if (gesture == Gesture.TWO_TAP) {
                    // do something on two finger tap
                    return true;
                } else if (gesture == Gesture.SWIPE_RIGHT) {
                    // do something on right (forward) swipe
                    Log.i("Swipe","RIGHT");
                    if(position < imagesArray.length-1) {
                        position++;
                        setImage(position);
                    }

                    return true;
                } else if (gesture == Gesture.SWIPE_LEFT) {
                    // do something on left (backwards) swipe
                    Log.i("Swipe","LEFT");
                    if(position > 0){
                        position--;
                        setImage(position);
                    }
                    return true;
                }
                return false;
            }
        });
        return gestureDetector;
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if (mGestureDetector != null) {
            return mGestureDetector.onMotionEvent(event);
        }
        return false;
    }
}
