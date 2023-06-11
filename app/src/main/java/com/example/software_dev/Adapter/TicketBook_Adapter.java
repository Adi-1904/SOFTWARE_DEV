package com.example.software_dev.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.software_dev.R;
import com.example.software_dev.ViewHolder.TicketViewholder;
import com.example.software_dev.dataitem.Booking_dataModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Objects;

public class TicketBook_Adapter extends RecyclerView.Adapter<TicketViewholder> {
    Context context;
    ArrayList<Booking_dataModel> userArraylist;
    TextView yes,no;

    public TicketBook_Adapter(Context context, ArrayList<Booking_dataModel> userArraylist) {
        this.context = context;
        this.userArraylist = userArraylist;
    }

    @Override
    public TicketViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TicketViewholder(LayoutInflater.from(context).inflate(R.layout.booking_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewholder holder, int position) {
        holder.Moviename.setText(String.valueOf(userArraylist.get(position).getMoviename()));
        holder.seatno.setText(String.valueOf(userArraylist.get(position).getSeat()));
        holder.hallname.setText(String.valueOf(userArraylist.get(position).getHallname()));
        holder.date.setText(String.valueOf(userArraylist.get(position).getDate()));
        holder.time.setText(String.valueOf(userArraylist.get(position).getTime()));
        String sts=String.valueOf(userArraylist.get(position).getImage());
        if(sts=="0")
        {
            holder.status.setImageResource(R.drawable.cancelled);
        }


//        holder.btn_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(context,R.style.bottomsheetstyle);
//                bottomSheetDialog.setContentView(R.layout.dialog);
//                yes=bottomSheetDialog.findViewById(R.id.deleteyes);
//                no=bottomSheetDialog.findViewById(R.id.deleteno);
//                yes.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
////                        holder.status.setImageResource(R.drawable.cancelled);
//                    }
//                });
//                no.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        bottomSheetDialog.dismiss();
//                    }
//                });
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return userArraylist.size();
    }
}
