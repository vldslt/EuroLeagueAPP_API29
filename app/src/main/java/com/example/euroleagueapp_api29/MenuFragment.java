package com.example.euroleagueapp_api29;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {

    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }
    /*
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        Button tap_for_prediction = requireActivity().findViewById(R.id.btn_games);
        tap_for_prediction.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.viewPager, PredictionFragment.newInstance())
                    .addToBackStack("")
                    .commit();
        });
        Button tap_for_stats = requireActivity().findViewById(R.id.btn_stats);
        tap_for_stats.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.viewPager, StatsFragment.newInstance())
                    .addToBackStack("")
                    .commit();
        });
        Button tap_for_table_tour = requireActivity().findViewById(R.id.btn_table_tour);
        tap_for_table_tour.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.viewPager, TabletourFragment.newInstance())
                    .addToBackStack("")
                    .commit();
        });
        Button tap_for_table = requireActivity().findViewById(R.id.btn_table);
        tap_for_table.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.viewPager, TableseasonFragment.newInstance())
                    .addToBackStack("")
                    .commit();
        });
    }

}