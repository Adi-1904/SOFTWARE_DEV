package com.example.software_dev;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.software_dev.Adapter.latestmovie_Adapter;
import com.example.software_dev.Adapter.upcomingmovie_adapter;
import com.example.software_dev.dataitem.data_item;
import com.example.software_dev.dataitem.upcomingdataitem;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment{
    RecyclerView latestrecyclerView;
    RecyclerView upcomingrecyclerView;
    latestmovie_Adapter adapter;
    FirebaseFirestore firestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        //latest RECYCLER VIEW
        latestrecyclerView=view.findViewById(R.id.latest_recyclerview);
        List<data_item> items=new ArrayList<data_item>();
        items.add(new data_item("Avenger Endgame","4.5",R.drawable.avengers));
        items.add(new data_item("john wick","5",R.drawable.johnwick));
        items.add(new data_item("Fast x","4.5",R.drawable.fastx));
        items.add(new data_item("suzume","3.2",R.drawable.suzume));
        latestrecyclerView.setAdapter(new latestmovie_Adapter(getContext(),items));

        // Upcoming RECYCLER VIEW
        upcomingrecyclerView=view.findViewById(R.id.upcoming_recyclerview);
        List<upcomingdataitem> upcomingitems=new ArrayList<upcomingdataitem>();
        upcomingitems.add(new upcomingdataitem("avenger","4.5"));
        upcomingitems.add(new upcomingdataitem("john wick","5"));
        upcomingitems.add(new upcomingdataitem("tu jhuthi main makkar","4.5"));
        upcomingitems.add(new upcomingdataitem("suzume","3.2"));
        upcomingrecyclerView.setAdapter(new upcomingmovie_adapter(getContext(),upcomingitems));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finishAffinity();
            }
        });
    }


}