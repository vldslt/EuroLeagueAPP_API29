package com.example.euroleagueapp_api29.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.euroleagueapp_api29.R;


public class TableseasonFragment extends Fragment {

    public static TableseasonFragment newInstance() {
        TableseasonFragment fragment = new TableseasonFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tableseason, container, false);
    }
}