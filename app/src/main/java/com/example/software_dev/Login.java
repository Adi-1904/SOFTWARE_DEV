package com.example.software_dev;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.software_dev.databinding.FragmentLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class Login extends Fragment {
    String et_email,et_password;
    FirebaseAuth auth;
    FirebaseFirestore data;
    private FragmentLoginBinding binding;
    private int Rc_Sign_in=100;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        auth=FirebaseAuth.getInstance();
        data=FirebaseFirestore.getInstance();

        binding.forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(Login.this).navigate(R.id.action_login_to_forgetPassword);
            }
        });
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_email=binding.loginEmail.getText().toString();
                et_password=binding.loginPassword.getText().toString();
                signup(et_email,et_password);

            }
        });
        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(Login.this).navigate(R.id.action_login_to_signup);
            }
        });

    }

    private void signup(String et_email, String et_password) {
        auth.signInWithEmailAndPassword(et_email, et_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(requireContext(), Dashboard.class);
                    intent.putExtra("email", et_email);
                    startActivity(intent);
                } else if (task.isCanceled())
                    Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show();
            }

        });

    }

}