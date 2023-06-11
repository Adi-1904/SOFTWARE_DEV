package com.example.software_dev.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.software_dev.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class TicketViewholder extends RecyclerView.ViewHolder {
    public TextView Moviename;
    public TextView date;
    public TextView hallname;
    public TextView row;
    public TextView time,yes,no;
    public TextView seatno;
    public ImageView status;
    public Button cancel;
    FirebaseFirestore firestore;
    String user;
    public TicketViewholder(@NonNull View itemView) {

        super(itemView);
        firestore=FirebaseFirestore.getInstance();
        Moviename=itemView.findViewById(R.id.Moviename);
        seatno=itemView.findViewById(R.id.seatno);
        hallname=itemView.findViewById(R.id.Cinemaname);
        date=itemView.findViewById(R.id.Movie_date);
        time=itemView.findViewById(R.id.Movie_time);
        status=itemView.findViewById(R.id.status);
        cancel=itemView.findViewById(R.id.btn_cancel);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(v.getContext());
                View bottomsheetview= LayoutInflater.from(v.getContext()).inflate(R.layout.dialog,null);
                bottomSheetDialog.setContentView(bottomsheetview);
                bottomSheetDialog.show();
                yes=bottomSheetDialog.findViewById(R.id.deleteyes);
                no=bottomSheetDialog.findViewById(R.id.deleteno);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        status.setImageResource(R.drawable.cancelled);
                        bottomSheetDialog.dismiss();
                        cancel.setVisibility(View.GONE);
                        Toast.makeText(v.getContext(), "Your amount will be refunded within 2-3 working days", Toast.LENGTH_LONG).show();
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

    }
}
