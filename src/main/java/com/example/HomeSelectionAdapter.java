package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HomeSelectionAdapter extends BaseAdapter{
    private List<String> selections;

    public HomeSelectionAdapter(List<String> selections){
        this.selections = selections;
    }

    @Override
    public int getCount() {
        return selections.size();
    }

    @Override
    public String getItem(int position) {
        return selections.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = convertView;
        if(convertView==null)
            view = layoutInflater.inflate(R.layout.home_list_item, null);

        String selectionText = selections.get(position);

        TextView textView = (TextView)view.findViewById(R.id.label);
        textView.setText(selectionText);

        ImageView imageView = (ImageView)view.findViewById(R.id.home_menu_icon);
        if(selectionText.startsWith("See"))
            imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.pullup_icon));
        else if(selectionText.startsWith("Visit"))
            imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.facebook_thumb));
        else if(selectionText.startsWith("Search"))
            imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.search_icon));
        else if(selectionText.startsWith("Log"))
            imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.red_book_icon));

        return view;
    }
}
