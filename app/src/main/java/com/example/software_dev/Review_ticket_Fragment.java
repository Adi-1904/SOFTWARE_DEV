package com.example.software_dev;

import static androidx.fragment.app.FragmentManager.TAG;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.software_dev.dataitem.SeatBooked;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Review_ticket_Fragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    FirebaseFirestore firestore;
    List<String> selectedSeatNumbers = new ArrayList<>();
    Map<String, Object> data = new HashMap<>();
    Button pay;
    int seatno=0;
    Bundle bundle = new Bundle();
    
    String moviename,hallselect,date,time,arrayvalue=null,user;
    CheckBox a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,d1,d2,d3,d4;
    TextView Movie_name,cinemahall_name,Movie_time,Movie_date;
    Map<String,Object> seatbooked=new HashMap<>();

    ArrayList<String> alreadybooked=new ArrayList<>();
    ArrayList<String> bookedseatArrayList;
    String[] array ;
    String[] newarray ;
    List<String> sbs;
    String k[];
    payment_fragment payment_fragment=new payment_fragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_review_ticket_, container, false);

        moviename=getArguments().getString("Moviename");
        hallselect=getArguments().getString("cinemaname");
        date=getArguments().getString("DATE");
        time=getArguments().getString("time");



// Add data to the Bundle
        bundle.putString("Moviename",moviename);
        bundle.putString("cinemaname",hallselect);
        bundle.putString("DATE",date);
        bundle.putString("time",time);
        payment_fragment.setArguments(bundle);
        if(date==null)
            date="17 may";


        firestore=FirebaseFirestore.getInstance();

        Movie_name=view.findViewById(R.id.Movie_name);
        cinemahall_name=view.findViewById(R.id.cinemahall_name);
        Movie_date=view.findViewById(R.id.Movie_date);
        Movie_time=view.findViewById(R.id.Movie_time);

        Movie_name.setText(String.valueOf(moviename));
        cinemahall_name.setText(String.valueOf(hallselect));
        Movie_date.setText(String.valueOf(date));
        Movie_time.setText(String.valueOf(time));

        AppCompatActivity activity= (AppCompatActivity) view.getContext();




        a1=view.findViewById(R.id.seatA1);
        a2=view.findViewById(R.id.seatA2);
        a3=view.findViewById(R.id.seatA3);
        a4=view.findViewById(R.id.seatA4);
        b1=view.findViewById(R.id.seatB1);
        b2=view.findViewById(R.id.seatB2);
        b3=view.findViewById(R.id.seatB3);
        b4=view.findViewById(R.id.seatB4);
        c1=view.findViewById(R.id.seatC1);
        c2=view.findViewById(R.id.seatC2);
        c3=view.findViewById(R.id.seatC3);
        c4=view.findViewById(R.id.seatC4);
        d1=view.findViewById(R.id.seatD1);
        d2=view.findViewById(R.id.seatD2);
        d3=view.findViewById(R.id.seatD3);
        d4=view.findViewById(R.id.seatD4);

        DocumentReference documentReference=firestore.collection(moviename).document(hallselect+date);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    // Document data exists

                    Log.d("Testingg",documentSnapshot.toString());
                    Map<String, Object> data = documentSnapshot.getData();

                    if (data != null) {
                        Log.d("Testingg",data.keySet().toString());
                        for(String i : data.keySet()){
                            sbs= (ArrayList<String>) documentSnapshot.get(FieldPath.of(i));
                            SeatBooked sb= new SeatBooked((ArrayList<String>) sbs);
                            Log.d("Testing", sbs.get(0));
                            arrayvalue=String.valueOf(sb.getKuchbhi().get(0));

                        }

//                        ArrayList<String> array = (ArrayList<String>) documentSnapshot.get(date+","+time);
//                        SeatBooked sb=da
                        //                        alreadybooked=array;
//                        HashSet<String> newuniqueSet = new HashSet<>(alreadybooked);
//                        bookedseatArrayList = new ArrayList<>(newuniqueSet);
//                        arrayvalue=array.get(0);



                    }
                } else {
                    // Document does not exist
                    Log.d("data", "No such document!");
                }
            }
        });

        pay=view.findViewById(R.id.pay);

        a1.setOnCheckedChangeListener(this);
        a2.setOnCheckedChangeListener(this);
        a3.setOnCheckedChangeListener(this);
        a4.setOnCheckedChangeListener(this);
        b1.setOnCheckedChangeListener(this);
        b2.setOnCheckedChangeListener(this);
        b3.setOnCheckedChangeListener(this);
        b4.setOnCheckedChangeListener(this);
        c1.setOnCheckedChangeListener(this);
        c2.setOnCheckedChangeListener(this);
        c3.setOnCheckedChangeListener(this);
        c4.setOnCheckedChangeListener(this);
        d1.setOnCheckedChangeListener(this);
        d2.setOnCheckedChangeListener(this);
        d3.setOnCheckedChangeListener(this);
        d4.setOnCheckedChangeListener(this);
        pay.setVisibility(View.GONE);
//ticket

            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DocumentReference documentRef = firestore.collection(moviename).document(hallselect + date);
                    documentRef.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
//                        Toast.makeText(getContext(),"Successfull", Toast.LENGTH_SHORT).show();
                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, payment_fragment).commit();
                        }
                    });


                }
            });

        return view;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId())
        {
            case R.id.seatA1:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatA2:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatA3:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatA4:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatB1:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatB2:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatB3:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatB4:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatC1:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatC2:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatC3:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatC4:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatD1:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatD2:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatD3:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
            case R.id.seatD4:
                if (isChecked) {
                    selectedSeatNumbers.add(String.valueOf(buttonView.getText()));
                    seatno=seatno+1;;
                } else {
                    selectedSeatNumbers.remove(String.valueOf(buttonView.getText()));
                    seatno=seatno-1;
                }
                HashSet<String> uniqueSet = new HashSet<>(selectedSeatNumbers);
                ArrayList<String> uniqueArrayList = new ArrayList<>(uniqueSet);
                String seatselect=TextUtils.join(",",uniqueArrayList);
                String total= String.valueOf(100*uniqueArrayList.size());
                pay.setText(total);
//                String result = TextUtils.join(",", uniqueArrayList);
             //   result=result;
                HashSet<String> seatcheck = new HashSet<>(uniqueArrayList);
                alreadybooked=new ArrayList<>(seatcheck);
                List<String> list = new ArrayList<>(alreadybooked);
                if (sbs!=null)
                list.addAll(sbs);
                HashSet<String> newlist=new HashSet<>(list);
                ArrayList<String> newlist_array=new ArrayList<>(newlist);
                List<String> list_final = new ArrayList<>(newlist_array);

                String Field= date+","+time;
                data.put(Field, list_final);
                bundle.putString("seat",seatselect);
                if(seatno==0)
                {
                    Toast.makeText(requireContext(), "Select seat", Toast.LENGTH_SHORT).show();
                    pay.setVisibility(View.GONE);
                }
                else
                    pay.setVisibility(View.VISIBLE);


        }
    }
}