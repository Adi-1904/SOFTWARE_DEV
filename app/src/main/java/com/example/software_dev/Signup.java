package com.example.software_dev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.software_dev.databinding.FragmentSignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends Fragment {
    private FragmentSignUpBinding binding;
    String name,number,email,password;
    FirebaseAuth auth;
    FirebaseFirestore data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSignUpBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        auth=FirebaseAuth.getInstance();
        data=FirebaseFirestore.getInstance();
        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(Signup.this).navigate(R.id.action_signup_to_login);
            }
        });
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       name=binding.name.getText().toString();
                                                       email=binding.RegisterEmail.getText().toString();
                                                       password=binding.RegisterPassword.getText().toString();
                                                       number=binding.number.getText().toString();
                                                       registerEmail(email,password,name,number);

                                                   }
                                               }
        );
    }

    private void registerEmail(String email, String password, String name, String number) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String userid=auth.getCurrentUser().getUid();
                Map<String,Object> details=new HashMap<>();
                details.put("name",name);
                details.put("number",number);
                details.put("email",email);
                data.collection("student").document(userid).set(details).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        NavHostFragment.findNavController(Signup.this).navigate(R.id.action_signup_to_login);
                    }
                });
            }
        });
    }
}