package com.example.deepakp.test_project.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.deepakp.test_project.R;
import com.example.deepakp.test_project.activities.ChatActivity;

import java.util.ArrayList;

/**
 * Created by deepakp on 12/5/2016.
 */

public class ListViewCustomAdaptor extends BaseAdapter {

    ArrayList<String> arrayList;
    GridView listView;
    LayoutInflater inflater;
    Activity context;


        public ListViewCustomAdaptor(GridView gridView, ArrayList<String> arrayList, Activity context)
        {
            this.listView=gridView;
            this.arrayList=arrayList;
            this.context=context;

        }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = null;

        if(convertView==null)
        {
            holder=new Holder();
           // inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater=context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item,null);
            holder.textView=(TextView)convertView.findViewById(R.id.textview);
            holder.button=(Button)convertView.findViewById(R.id.delete_button);
            holder.button.setTag(position);
            holder.button.setVisibility(View.GONE);
            convertView.setTag(holder);
        }
    else {
            holder = (Holder) convertView.getTag();
        }

        holder.textView.setText(arrayList.get(position));
     holder.button.setOnClickListener(onClickListener);

        return convertView;

    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(final View  v) {

            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setTitle("Alert !!").setMessage("Do you want to delete this item");
            builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

//                    int pos = (int)v.getTag();
//                    arrayList.remove(pos);
//                    ListViewCustomAdaptor.this.notifyDataSetChanged();
//
                    context.startActivity(new Intent(context,ChatActivity.class));

                }
            });builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });builder.show();


          /*  arrayList.remove((int)v.getTag());
            listView.invalidateViews();
            notifyDataSetChanged();*/

        }
    };


    static class  Holder{

        TextView textView;
        Button button;
    }

}
