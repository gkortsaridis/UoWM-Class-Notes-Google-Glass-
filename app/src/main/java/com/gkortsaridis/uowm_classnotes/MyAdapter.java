package com.gkortsaridis.uowm_classnotes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.glass.widget.CardScrollAdapter;

import java.util.ArrayList;

/**
 * Created by yoko on 08/01/2017.
 */

public class MyAdapter extends CardScrollAdapter {

    private Context context;
    private ArrayList<String> names;

    public MyAdapter(Context context, ArrayList<String> names){
        this.context = context;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View tem;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        tem = layoutInflater.inflate(R.layout.listview_item_lessons, null);

        TextView lesson_name = (TextView) tem.findViewById(R.id.lesson_name);
        lesson_name.setText(names.get(i));

        return tem;
    }

    @Override
    public int getPosition(Object o) {
        return 0;
    }

}
