package com.example.software_dev;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class payment_fragment extends Fragment {
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    EditText cardbnumber,carddate,cardname,upiid,upinumber;
    Button savecard,pay;
    TextView verify1,verify2;
    String pattern = "[\\w.-]+@[\\w]+";
    String moviename,hallselect,date,time,seat,user;
    Home home=new Home();
    Boolean check=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_payment_fragment, container, false);

        auth=FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();

        cardbnumber=view.findViewById(R.id.et_cardnumber);
        carddate=view.findViewById(R.id.et_Expiry);
        cardname=view.findViewById(R.id.et_name);
        upiid=view.findViewById(R.id.upi_id);
        upinumber=view.findViewById(R.id.upi_mobile);
        savecard=view.findViewById(R.id.btn_savecard);
        pay=view.findViewById(R.id.final_pay);
        verify1=view.findViewById(R.id.verifyid);
        verify2=view.findViewById(R.id.verifynumber);
        moviename=getArguments().getString("Moviename");
        hallselect=getArguments().getString("cinemaname");
        date=getArguments().getString("DATE");
        time=getArguments().getString("time");
        seat=getArguments().getString("seat");
        Map<String,Object> seatbooked=new HashMap<>();
        AppCompatActivity activity= (AppCompatActivity) view.getContext();
        savecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardbnumber.getText().toString().trim().isEmpty()) {
                    cardbnumber.setError("Please enter Card number");
                    check=false;
                }
                else if(carddate.getText().toString().trim().isEmpty()) {
                    carddate.setError("please enter expiry date");
                    check=false;
                }
                else if (cardname.getText().toString().trim().isEmpty()) {
                    check = false;
                    cardname.setError("Please Enter Card Holder Name");
                }
                else
                {
                    Toast.makeText(requireContext(), "Card saved Successfully", Toast.LENGTH_SHORT).show();
                    check=true;
                }
            }
        });
        verify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upiid.getText().toString().matches(pattern))
                {
                    verify1.setTextColor(Color.GREEN);
                    check=true;
                }
                else
                    upiid.setError("Enter Valid upi Id");
            }
        });
        verify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upinumber.getText().toString().length()==10)
                {
                    verify2.setTextColor(Color.GREEN);
                    check=true;
                }
                else
                    upinumber.setError("Enter Valid Mobile Number");

            }
        });

        seatbooked.put("Moviename",moviename);
        seatbooked.put("hallname",hallselect);
        seatbooked.put("date",date);
        seatbooked.put("time",time);
        seatbooked.put("image","1");
        seatbooked.put("seat",seat);


        if(cardbnumber.getText().toString().trim().isEmpty()||carddate.getText().toString().trim().isEmpty()||cardname.getText().toString().trim().isEmpty())
            check=false;
        else if (upiid.getText().toString().isEmpty()) {
            check=false;

        } else if (upinumber.getText().toString().isEmpty()) {
            check=false;
        }
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check)
                {
                    user = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    DocumentReference reference = firestore.collection(user).document();
                    reference.set(seatbooked).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getContext(), "Booked Successfully", Toast.LENGTH_SHORT).show();
                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,home).commit();
                        }
                    });
                }
                else
                    Toast.makeText(requireContext(), "Enter Credential", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}