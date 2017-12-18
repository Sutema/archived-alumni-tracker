package com.sutema.apps.alumnitracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        View row = convertView;
        LokerHolder lokerHolder;

        if (row == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            row = layoutInflater.inflate(layoutResourceId,parent,false);

            lokerHolder = new LokerHolder();

            lokerHolder.positionTxt = row.findViewById(R.id.txt_position);
            lokerHolder.companyTxt = row.findViewById(R.id.txt_company);
            lokerHolder.descTxt = row.findViewById(R.id.txt_desc);
            lokerHolder.companyImg = row.findViewById(R.id.img_loker);

            row.setTag(lokerHolder);
        }else{
            lokerHolder = (LokerHolder) row.getTag();
        }

        Loker loker = data[position];

        lokerHolder.companyImg.setOnClickListener(PopupListener);
        Integer rowPosition = position;
        lokerHolder.companyImg.setTag(rowPosition);

        lokerHolder.positionTxt.setText(loker.getPosition());
        lokerHolder.companyTxt.setText(loker.getCompany());
        lokerHolder.descTxt.setText(loker.getDesc());
        return row;
    }

    private View.OnClickListener PopupListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer viewPosition = (Integer) view.getTag();
            Loker l = data[viewPosition];
            Toast.makeText(getContext(), l.getPosition(),Toast.LENGTH_SHORT).show();
        }
    };



    private static class LokerHolder{
        TextView positionTxt;
        TextView companyTxt;
        TextView descTxt;
        ImageView companyImg;
    }
}
