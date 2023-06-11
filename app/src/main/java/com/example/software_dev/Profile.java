package com.example.software_dev;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.software_dev.dataitem.Booking_dataModel;
import com.example.software_dev.dataitem.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Profile extends Fragment {
    TextView username;
    TextView email;
    TextView mobile;
    Button logout;
    String user;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    ArrayList<user> userArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        auth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();
        username=view.findViewById(R.id.tv_name);
        email=view.findViewById(R.id.tv_Email);
        mobile=view.findViewById(R.id.tv_Mobileno);
        logout=view.findViewById(R.id.btnLogOut);
        user=FirebaseAuth.getInstance().getCurrentUser().getUid();
        firestore.collection("student").document(user).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful())
                {
                    DocumentSnapshot documentSnapshot=task.getResult();
                    if(documentSnapshot.exists())
                    {
                        user user1=documentSnapshot.toObject(user.class);
                        username.setText(user1.getName());
                        mobile.setText(String.valueOf(user1.getNumber()));
                        email.setText(String.valueOf(user1.getEmail()));
                    }
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent intent= new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}