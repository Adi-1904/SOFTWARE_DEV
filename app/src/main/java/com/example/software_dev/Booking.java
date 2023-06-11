package com.example.software_dev;

import static androidx.fragment.app.FragmentManager.TAG;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.software_dev.Adapter.TicketBook_Adapter;
import com.example.software_dev.dataitem.Booking_dataModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Booking extends Fragment {
    FirebaseFirestore firestore;
    TextView msg1;
    RecyclerView recyclerView;
    ArrayList<Booking_dataModel> userArrayList;
    TicketBook_Adapter adapter;

    String user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        msg1=view.findViewById(R.id.msg);
        recyclerView=view.findViewById(R.id.Ticket_RecyclerView);
        firestore=FirebaseFirestore.getInstance();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        userArrayList=new ArrayList<Booking_dataModel>();
        adapter=new TicketBook_Adapter(getContext(),userArrayList);
        recyclerView.setAdapter(adapter);
        EvenchangeListener();



        return view;
    }

    private void EvenchangeListener() {
        user= FirebaseAuth.getInstance().getCurrentUser().getUid();
        firestore.collection(user).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.e("firebase error", error.getMessage());
                    return;
                }
            for (DocumentChange dc: value.getDocumentChanges())
            {
                if(dc.getType()==DocumentChange.Type.ADDED)
                {
                    userArrayList.add(dc.getDocument().toObject(Booking_dataModel.class));
                }
                if (!userArrayList.isEmpty())
                    msg1.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            }
            }
        });
    }
}