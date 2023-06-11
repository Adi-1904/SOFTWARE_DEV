package com.example.software_dev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.software_dev.databinding.FragmentForgetPasswordBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends Fragment {
    FirebaseAuth auth;
    private FragmentForgetPasswordBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentForgetPasswordBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        auth = FirebaseAuth.getInstance();
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ForgetPassword.this).navigate(R.id.action_forgetPassword_to_login);
            }
        });
        binding.forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.loginEmail.getText().toString();
                forget(email);
            }
        });
    }

    private void forget(String email) {
        auth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(requireContext(), "Reset link has been sent to email", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(ForgetPassword.this).navigate(R.id.action_forgetPassword_to_login);
            }
        });
    }
}