package com.example.software_dev.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.software_dev.R;
import com.example.software_dev.ViewHolder.latest_ViewHolder;
import com.example.software_dev.dataitem.upcomingdataitem;

import java.util.List;

public class upcomingmovie_adapter extends RecyclerView.Adapter<latest_ViewHolder> {
    Context context;
    List<upcomingdataitem> list;

    public upcomingmovie_adapter(Context context, List<upcomingdataitem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public latest_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new latest_ViewHolder(LayoutInflater.from(context).inflate(R.layout.latest_movie_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull latest_ViewHolder holder, int position) {
        holder.MovieName.setText(String.valueOf(list.get(position).getupcoming_moviename()));
        holder.Rating.setText(String.valueOf(list.get(position).getupcoming_rating()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
