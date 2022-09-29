package com.example.euroleagueapp_api29;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

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
        initView(view);

    }
    void initView(View view) {
        view.findViewById(R.id.btn_send_predictions).setOnClickListener(v -> showToast());
        view.findViewById(R.id.btn_match_1).setOnClickListener(v -> showAlertDialogCustom());
        view.findViewById(R.id.btn_match_2).setOnClickListener(v -> showAlertDialogCustom());
        view.findViewById(R.id.btn_match_3).setOnClickListener(v -> showAlertDialogCustom());
        view.findViewById(R.id.btn_match_4).setOnClickListener(v -> showAlertDialogCustom());
        view.findViewById(R.id.btn_match_5).setOnClickListener(v -> showAlertDialogCustom());
        view.findViewById(R.id.btn_match_6).setOnClickListener(v -> showAlertDialogCustom());
        view.findViewById(R.id.btn_match_7).setOnClickListener(v -> showAlertDialogCustom());
        view.findViewById(R.id.btn_match_8).setOnClickListener(v -> showAlertDialogCustom());
        view.findViewById(R.id.btn_match_9).setOnClickListener(v -> showAlertDialogCustom());
        view.findViewById(R.id.btn_match_10).setOnClickListener(v -> showAlertDialogCustom());
    }
    void showAlertDialogCustom() {
        View view = getLayoutInflater().inflate(R.layout.dialog_custom_prediction, null);
        AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                .setTitle("Оставь свой прогноз")
                .setMessage("в формате: 1-1")
                .setView(view)
                .show();
        view.findViewById(R.id.btn_edit_prediction).setOnClickListener(v -> {
            EditText editText = view.findViewById(R.id.edit_prediction);
            showToast(editText.getText().toString());
            alertDialog.dismiss();
        });
    }

    void showToast(){
        Toast.makeText(requireContext(), "отправлено",Toast.LENGTH_SHORT).show();
    }
    void showToast(String s){
        Toast.makeText(requireContext(), "отправлено",Toast.LENGTH_SHORT).show();
    }
}