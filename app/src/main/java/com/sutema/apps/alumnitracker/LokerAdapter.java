package com.sutema.apps.alumnitracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Febrinanda on 12/18/2017.
 * Happy Coding Worlds!
 */

public class LokerAdapter extends ArrayAdapter<Loker> {
    private Context context;
    private int layoutResourceId;
    private Loker data[] = null;

    LokerAdapter(Context context, int resource, Loker[] data){
        super(context,resource,data);
        this.context = context;
        this.layoutResourceId = resource;
        this.data = data;
    }
    @Nullable
    @Override
    public Loker getItem(int position) {
        return super.getItem(position);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        row = layoutInflater.inflate(layoutResourceId,parent,false);

        TextView positionTxt = row.findViewById(R.id.txt_position);
        TextView companyTxt = row.findViewById(R.id.txt_company);
        TextView descTxt = row.findViewById(R.id.txt_desc);

        Loker loker = data[position];

        positionTxt.setText(loker.getPosition());
        companyTxt.setText(loker.getCompany());
        descTxt.setText(loker.getPosition());
        return row;
    }
}
