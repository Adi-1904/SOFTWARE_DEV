package com.example.software_dev;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Hall_select extends Fragment implements View.OnClickListener {

    TextView moviename;
    RadioGroup radioGroup;
    String cinema_name,time;
    Bundle bundle=new Bundle();
    String date;
    int check;
    Review_ticket_Fragment review_ticket_fragment=new Review_ticket_Fragment();
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;

    private CardView selectedCardView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hall_select, container, false);
        String name=getArguments().getString("Moviename");
        moviename=view.findViewById(R.id.movie_name);
        moviename.setText(name);
        bundle.putString("Moviename",name);

        RadioButton defaultRadioButton = view.findViewById(R.id.btn1);

        radioGroup=view.findViewById(R.id.radio_group);
        radioGroup.check(defaultRadioButton.getId());
        date=defaultRadioButton.getText().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton=view.findViewById(checkedId);
                date=radioButton.getText().toString();
                check=checkedId;
                bundle.putString("DATE",date);
            }
        });

        btn1=view.findViewById(R.id.carnival_10_30);
        btn2=view.findViewById(R.id.carnival_12_00);
        btn3=view.findViewById(R.id.carnival_6_30);
        btn4=view.findViewById(R.id.cinemapolis_9_50);
        btn5=view.findViewById(R.id.cinemapolis_3_35);
        btn6=view.findViewById(R.id.cinemapolis_9_25);
        btn7=view.findViewById(R.id.rangoli_10_15);
        btn8=view.findViewById(R.id.rangoli_12);
        btn9=view.findViewById(R.id.rangoli_6_30);
        btn10=view.findViewById(R.id.pvr_10_00);
        btn11=view.findViewById(R.id.pvr_12_30);
        btn12=view.findViewById(R.id.pvr_6_30);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        AppCompatActivity activity= (AppCompatActivity) v.getContext();
        switch (v.getId())
        {
            case R.id.carnival_10_30:
                cinema_name="Carnival:Salt Lake";
                time="10:30 AM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.carnival_12_00:
                cinema_name="Carnival:Salt Lake";
                time="12:00 PM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.carnival_6_30:
                cinema_name="Carnival:Salt Lake";
                time="6:30 PM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.cinemapolis_9_25:
                cinema_name="Cinemapolis: Acropolis mall";
                time="09:25 PM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.cinemapolis_3_35:
                cinema_name="Cinemapolis: Acropolis mall";
                time="03:35 AM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.cinemapolis_9_50:
                cinema_name="Cinemapolis: Acropolis mall";
                time="09:50 AM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.rangoli_10_15:
                cinema_name="INOX:Rangoli";
                time="10:15 AM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.rangoli_12:
                cinema_name="INOX:Rangoli";
                time="12:00 PM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.rangoli_6_30:
                cinema_name="INOX:Rangoli";
                time="06:30 PM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.pvr_10_00:
                cinema_name="PVR:Avani";
                time="10:00 AM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.pvr_12_30:
                cinema_name="PVR:Avani";
                time="12:30 PM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
            case R.id.pvr_6_30:
                cinema_name="PVR:Avani";
                time="06:30 AM";
                bundle.putString("cinemaname",cinema_name);
                bundle.putString("time",time);
                review_ticket_fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,review_ticket_fragment).addToBackStack(null).commit();
                break;
        }
    }
}