package com.example.euroleagueapp_api29.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.euroleagueapp_api29.R;
import com.example.euroleagueapp_api29.rep.OnItemClickListener;

public class PredictionFragment extends Fragment implements OnItemClickListener {

    PredictionAdapter predictionAdapter = new PredictionAdapter();

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
        initAdapter();
        initRecycler(view);
    }
    void initAdapter(){
        predictionAdapter = new PredictionAdapter();
        LocalRepImpl localRepImpl = new LocalRepImpl(requireContext().getResources());
        predictionAdapter.setData(localRepImpl.init());
        /*RemoteRepositoryImpl remoteRepositoryImpl = new RemoteRepositoryImpl(requireContext());
        predictionAdapter.setData(remoteRepositoryImpl.init());
        для удоленного сервера заменить 45,46 строки
        */
        predictionAdapter.setOnItemClickListener(this);
    }

    void initRecycler(View view){
        RecyclerView recyclerView = view.findViewById(R.id.predictionList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(predictionAdapter); // связываем список с адаптером
    }
    String[] getData() {
        return getResources().getStringArray(R.array.games);
    }

    @Override
    public void onItemClick(int position) {    }
}