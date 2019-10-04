package com.example.fcm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Medicaladapter extends RecyclerView.Adapter<Medicaladapter.medicalViewHolder>{
    private  String[] data;
    public Medicaladapter(String[] data){
this.data=data;
    }
    @Override

    public medicalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_items,parent,false);
        return new medicalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(medicalViewHolder holder, int position) {
String title=data[position];
holder.text_title.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class medicalViewHolder extends RecyclerView.ViewHolder{
        ImageView image_icon;
        TextView text_title;
        public medicalViewHolder(View itemView) {
            super(itemView);
            image_icon=itemView.findViewById(R.id.image_icon);

        }
    }
}
