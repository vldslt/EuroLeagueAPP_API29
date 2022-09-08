package com.example.euroleagueapp_api29;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class PredictionFragment extends Fragment {

    public static PredictionFragment newInstance() {
        PredictionFragment fragment = new PredictionFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_prediction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] games = getResources().getStringArray(R.array.games);
        for (int i = 0; i < games.length; i++){
            String gameNumber = games[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(27f);
            textView.setText(gameNumber);
            ((LinearLayout) view).addView(textView);
    }

    }
}