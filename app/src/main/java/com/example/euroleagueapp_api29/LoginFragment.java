package com.example.euroleagueapp_api29;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

public class LoginFragment extends Fragment {

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,@NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button tap_for_register = requireActivity().findViewById(R.id.btn_tap_for_register);
        tap_for_register.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.viewPager, RegisterFragment.newInstance())
                    .commit();
    });
}
}