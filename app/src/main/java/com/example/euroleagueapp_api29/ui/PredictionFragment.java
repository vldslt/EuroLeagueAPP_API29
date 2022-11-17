package com.example.euroleagueapp_api29.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.euroleagueapp_api29.MainActivity;
import com.example.euroleagueapp_api29.R;
import com.example.euroleagueapp_api29.pub.Observer;
import com.example.euroleagueapp_api29.rep.CardData;
import com.example.euroleagueapp_api29.rep.CardSourse;

public class PredictionFragment<textView> extends Fragment implements OnItemClickListener {

    PredictionAdapter predictionAdapter;
    CardSourse data;

    public static PredictionFragment newInstance() {
        PredictionFragment fragment = new PredictionFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_prediction, container, false);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        initRecycler(view);
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        requireActivity().getMenuInflater().inflate(R.menu.card_menu, menu);
    } //задуваем меню в карточку

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int menuPosition = predictionAdapter.getMenuPosition();
        switch (item.getItemId()){
            case R.id.update: {
                /*
                data.makePredict(menuPosition, new CardData("введи свой прогноз","сюда"));
                predictionAdapter.notifyItemChanged(menuPosition);
                return true;
                }
                 */
                Observer observer = new Observer() {
                    @Override
                    public void receiveMessage(CardData cardData) {
                        data.makePredict(menuPosition, cardData);
                        ((MainActivity)requireActivity()).getPublisher().unsubscribe(this);
                    }
                };
                ((MainActivity)requireActivity()).getPublisher().subscribe(observer);
                ((MainActivity)requireActivity()).getSupportFragmentManager().beginTransaction().add(R.id.viewPager,PredictionRedactorFragment.newInstance(data.getCardData(menuPosition))).addToBackStack("").commit();
                return true;
            } case R.id.update1:{ }
        } return super.onContextItemSelected(item);
        }

    void initAdapter(){
        predictionAdapter = new PredictionAdapter(this);
        data = new LocalRepImpl(requireContext().getResources()).init();
        predictionAdapter.setData(data);
        /*RemoteRepositoryImpl remoteRepositoryImpl = new RemoteRepositoryImpl(requireContext());
        predictionAdapter.setData(remoteRepositoryImpl.init());
        для удоленного сервера заменить 45,46 строки
        */
        predictionAdapter.setOnItemClickListener(PredictionFragment.this);
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
    public void onItemClick(CardData position) { }
}