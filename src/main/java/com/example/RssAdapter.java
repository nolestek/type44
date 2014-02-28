package com.example;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class RssAdapter extends BaseAdapter {

    private final List<RssItem> items;
    private final Context context;

    public RssAdapter(Context context, List<RssItem> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.rss_item, null);
            holder = new ViewHolder();
            holder.itemTitle = (TextView) convertView.findViewById(R.id.itemTitle);
            holder.itemDescription = (TextView) convertView.findViewById(R.id.itemDescription);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        int pos = position;
        holder.itemTitle.setText(items.get(position).getTitle());
        String descript = trimHTMLFromText(items.get(position).getDescription());
        holder.itemDescription.setText(descript);
        //holder.itemDescription.setText(items.get(position).getDescription());
        //holder.itemTitle.setBackgroundColor(0x00000000);
        //holder.itemDescription.setBackgroundColor(0x00000000);

        return convertView;
    }

    private  String trimHTMLFromText(String html) {
        String trimmed = removeCharacters(html, '<', '>');
        String newtrim = removeCharacters(trimmed, '&', ';');
        return newtrim;
    }

    private String removeCharacters(String string, Character startChar, Character endChar){
        int position1 = string.indexOf(startChar);
        if(position1==-1){
            return string;
        }
        int position2 = string.indexOf(endChar);
        if(position2 ==-1){
            return string;
        }
        StringBuilder builder = new StringBuilder(string);
        for(int i = position1; i<= position2; i++){

            builder.deleteCharAt(position1);


        }
        string = builder.toString();
        int newpos = string.indexOf(startChar);
        if(newpos!= -1){
            string = removeCharacters(string, startChar, endChar);
        }
        return string;
    }

    static class ViewHolder {
        TextView itemTitle;
        TextView itemDescription;
    }
}
