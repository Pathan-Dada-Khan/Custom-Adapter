package com.example.playstore;

import android.app.Activity;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MyListAdapter extends ArrayAdapter<Store> {

    public MyListAdapter(Activity content,ArrayList<Store> store) {
        super(content,0,store);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View rowView=convertView;

         if(rowView==null){
             rowView=LayoutInflater.from(getContext()).inflate(R.layout.listview,parent,false);
         }

         Store current=getItem(position);

         TextView title=rowView.findViewById(R.id.title);
         title.setText(current.getTitle());

         TextView des=rowView.findViewById(R.id.des);
         des.setText(current.getDes());

         ImageView img=rowView.findViewById(R.id.img);
         img.setImageResource(current.getImg());

         return rowView;
    }
}
