package com.example.euroleagueapp_api29;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class TabletourFragment extends Fragment {

    public static TabletourFragment newInstance() {
        TabletourFragment fragment = new TabletourFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tabletour, container, false);
    }
}