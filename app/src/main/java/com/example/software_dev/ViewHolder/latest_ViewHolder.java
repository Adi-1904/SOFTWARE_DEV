package com.example.software_dev.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.software_dev.R;
import com.example.software_dev.RecyclerView_Interface;

public class latest_ViewHolder extends RecyclerView.ViewHolder {
    public TextView Rating;
    public TextView MovieName;

    public ImageView MoviePoster;
    public latest_ViewHolder(@NonNull View itemView) {
        super(itemView);
        Rating=itemView.findViewById(R.id.rating);
        MovieName=itemView.findViewById(R.id.movie_name);
        MoviePoster=itemView.findViewById(R.id.movie_poster);
    }
}
