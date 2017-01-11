package com.gkortsaridis.uowm_classnotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;

public class LessonActivity extends Activity {

    private CardScrollView mCardScroller;
    private ArrayList<String> lessonNames;
    private int whichLesson;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lessonNames = new ArrayList<String>();

        whichLesson = getIntent().getExtras().getInt("lesson");
        if(whichLesson == 0){
            lessonNames.add("Ανάλυση & Προσομοίωση Δικτύων Επικοινωνιών, Μάθημα 1");
            lessonNames.add("Ανάλυση & Προσομοίωση Δικτύων Επικοινωνιών, Μάθημα 2");
            lessonNames.add("Ανάλυση & Προσομοίωση Δικτύων Επικοινωνιών, Μάθημα 3");
        }else if(whichLesson == 1){
            lessonNames.add("Ασφάλεια Υπολογιστών και Δικτύων, Μάθημα 1");
            lessonNames.add("Ασφάλεια Υπολογιστών και Δικτύων, Μάθημα 2");
            lessonNames.add("Ασφάλεια Υπολογιστών και Δικτύων, Μάθημα 3");
            lessonNames.add("Ασφάλεια Υπολογιστών και Δικτύων, Μάθημα 4");
            lessonNames.add("Ασφάλεια Υπολογιστών και Δικτύων, Μάθημα 5");
        }else if(whichLesson == 2){
            lessonNames.add("Οπτικές Επικοινωνίες και Δίκτυα, Μάθημα 1");
            lessonNames.add("Οπτικές Επικοινωνίες και Δίκτυα, Μάθημα 2");
            lessonNames.add("Οπτικές Επικοινωνίες και Δίκτυα, Μάθημα 3");
            lessonNames.add("Οπτικές Επικοινωνίες και Δίκτυα, Μάθημα 4");
            lessonNames.add("Οπτικές Επικοινωνίες και Δίκτυα, Μάθημα 5");
        }else if(whichLesson == 3){
            lessonNames.add("Συστήματα Ουρών Αναμονής, Μάθημα 1");
            lessonNames.add("Συστήματα Ουρών Αναμονής, Μάθημα 2");
        }else{
            lessonNames.add("Unknown Lesson, SORRY :)");
        }

        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new MyAdapter(getBaseContext(),lessonNames));
        mCardScroller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Tapped",position+"");
                Intent intent = new Intent(LessonActivity.this,SlidesActivity.class);
                intent.putExtra("lesson",whichLesson);
                intent.putExtra("slide",position);
                startActivity(intent);
            }
        });
        setContentView(mCardScroller);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }
}
