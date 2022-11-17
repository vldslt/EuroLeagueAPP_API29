package com.example.euroleagueapp_api29.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.euroleagueapp_api29.MainActivity;
import com.example.euroleagueapp_api29.R;
import com.example.euroleagueapp_api29.rep.CardData;

public class PredictionRedactorFragment extends Fragment {

    CardData cardData;

    public static PredictionRedactorFragment newInstance(CardData cardData) {
        PredictionRedactorFragment fragment = new PredictionRedactorFragment();
        Bundle args = new Bundle();
        args.putParcelable("cardData", cardData);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_prediction_redactor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            cardData = getArguments().getParcelable("cardData");
            ((TextView) view.findViewById(R.id.inputTitle)).setText(cardData.getTitle());
            //((TextView) view.findViewById(R.id.inputDescription)).setText(cardData.getPredict());
            view.findViewById(R.id.btn_save_predict).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View it) {
                    cardData.setTitle(((TextView)view.findViewById(R.id.inputTitle)).getText().toString());
                    cardData.setPredict(((TextView)view.findViewById(R.id.inputDescription)).getText().toString());

                    ((MainActivity) requireActivity()).getPublisher().sendMessage(cardData);
                    ((MainActivity) requireActivity()).getSupportFragmentManager().popBackStack();
                }
            });
        }
    }
}