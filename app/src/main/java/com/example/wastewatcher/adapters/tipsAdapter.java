package com.example.wastewatcher.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wastewatcher.R;

import java.util.ArrayList;

public class tipsAdapter extends ArrayAdapter<String> {

    Context context;
    int res;

    public tipsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> Tips) {
        super(context, resource, Tips);
        this.context = context;
        this.res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(res,parent,false);
        TextView textView = convertView.findViewById(R.id.tiptop);
        //
        textView.setText(getItem(position));

        return convertView;
    }
}
