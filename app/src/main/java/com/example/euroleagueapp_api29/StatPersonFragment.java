package com.example.euroleagueapp_api29;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StatPersonFragment extends Fragment {

    public static StatPersonFragment newInstance() {
        StatPersonFragment fragment = new StatPersonFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stat_person, container, false);
    }
}