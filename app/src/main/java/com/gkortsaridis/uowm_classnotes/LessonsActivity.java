package com.gkortsaridis.uowm_classnotes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;

public class LessonsActivity extends Activity {

    private CardScrollView mCardScroller;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        ArrayList<String> names = new ArrayList<String>();
        names.add("Ανάλυση & Προσομοίωση Δικτύων Επικοινωνιών");
        names.add("Ασφάλεια Υπολογιστών και Δικτύων");
        names.add("Οπτικές Επικοινωνίες και Δίκτυα");
        names.add("Συστήματα Ουρών Αναμονής");

        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new MyAdapter(getBaseContext(),names));
        mCardScroller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Tapped",position+"");
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.SELECTED);

                Intent intent = new Intent(LessonsActivity.this, LessonActivity.class);
                intent.putExtra("lesson",position);
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
