package edu.skku.cs.termproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<StepButton> items;

    public ListViewAdapter(Context mContext, ArrayList<StepButton> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view ==  null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.activity_list_view_layout, viewGroup, false);
        }

        TextView langTextView = view.findViewById(R.id.langTextView);
        TextView EngTextView = view.findViewById(R.id.EngTextView);


        langTextView.setText(items.get(i).stepText);
        EngTextView.setText(items.get(i).stepBtn);



        return view;
    }
}
