package com.example.euroleagueapp_api29;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StatsFragment extends Fragment {

    public static StatsFragment newInstance() {
        StatsFragment fragment = new StatsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stats, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button tap_for_stat_person = requireActivity().findViewById(R.id.btn_stat_person);
        tap_for_stat_person.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.viewPager, StatPersonFragment.newInstance())
                    .addToBackStack("")
                    .commit();
        });
        Button tap_for_stat_of_season = requireActivity().findViewById(R.id.btn_stat_ofseason);
        tap_for_stat_of_season.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.viewPager, StatOfSeasonFragment.newInstance())
                    .addToBackStack("")
                    .commit();
        });
        Button tap_for_records = requireActivity().findViewById(R.id.btn_records);
        tap_for_records.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.viewPager, TableRecordsFragment.newInstance())
                    .addToBackStack("")
                    .commit();
        });
    }
}