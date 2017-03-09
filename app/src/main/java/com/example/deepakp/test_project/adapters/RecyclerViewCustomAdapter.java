package com.example.deepakp.test_project.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.deepakp.test_project.R;
import com.example.deepakp.test_project.StringConstant.CommonString;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by deepakp on 1/27/2017.
 */

public class RecyclerViewCustomAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    ArrayList<HashMap<String,String>> contactdata;
    private LayoutInflater inflator;

    public RecyclerViewCustomAdapter(Context context,ArrayList<HashMap<String,String>> contactdata) {
        this.context = context;
        this.contactdata=contactdata;
        inflator = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.contacts_recycleritem, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name_txt.setText(contactdata.get(position).get(CommonString.Tag_CONTACTNAME));
        holder.number_txt.setText(contactdata.get(position).get(CommonString.Tag_CONTACTNUMBER));
    }

    @Override
    public int getItemCount() {
        return contactdata.size();
    }


}

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView name_txt, number_txt;
    ImageButton profilepicimage;

    public MyViewHolder(View itemView) {
        super(itemView);

        profilepicimage = (ImageButton) itemView.findViewById(R.id.profilepicimage);
        name_txt = (TextView) itemView.findViewById(R.id.contactname);
        number_txt = (TextView) itemView.findViewById(R.id.contactnumber);
    }
}
