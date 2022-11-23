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

import com.example.euroleagueapp_api29.MainActivity;
import com.example.euroleagueapp_api29.R;
import com.example.euroleagueapp_api29.pub.Observer;
import com.example.euroleagueapp_api29.rep.CardData;
import com.example.euroleagueapp_api29.rep.CardSourse;
import com.example.euroleagueapp_api29.rep.LocalRepImpl;
import com.example.euroleagueapp_api29.rep.RemoteFireStoreRepositoryImpl;

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
        predictionAdapter.setOnItemClickListener(PredictionFragment.this);
        // локальный репозиторий
         /*
        RemoteFireStoreRepositoryImpl remoteFireStoreRepositoryImpl = new RemoteFireStoreRepositoryImpl(requireContext());
        predictionAdapter.setData(remoteFireStoreRepositoryImpl.init());
        //для удаленного сервера заменить 45,46 строки

         */
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

//TODO:  void setupSource(){
//        switch (getCurrentSource()) {
//            case SOURCE_ARRAY:
//                data = new LocalRepositoryImpl(requireContext().getResources()).init();
//                initAdapter();
//                break;
//            case SOURCE_SP:
//                data = new LocalSharedPreferencesRepositoryImpl(requireContext().getSharedPreferences(LocalSharedPreferencesRepositoryImpl.KEY_SP_2,Context.MODE_PRIVATE)).init();
//                initAdapter();
//                break;
//            case SOURCE_GF:
//                data = new RemoteFireStoreRepositoryImpl().init(this);
//                initAdapter();
//                break;
//        }
//    }
//
//    private void initRadioGroup(View view) {
//        view.findViewById(R.id.sourceArrays).setOnClickListener(listener);
//        view.findViewById(R.id.sourceSP).setOnClickListener(listener);
//        view.findViewById(R.id.sourceGF).setOnClickListener(listener);
//
//        switch (getCurrentSource()) {
//            case SOURCE_ARRAY:
//                ((RadioButton) view.findViewById(R.id.sourceArrays)).setChecked(true);
//                break;
//            case SOURCE_SP:
//                ((RadioButton) view.findViewById(R.id.sourceSP)).setChecked(true);
//                break;
//            case SOURCE_GF:
//                ((RadioButton) view.findViewById(R.id.sourceGF)).setChecked(true);
//                break;
//        }
//
//    }
//
//    static final int SOURCE_ARRAY = 1;
//    static final int SOURCE_SP = 2;
//    static final int SOURCE_GF = 3;
//
//    static String KEY_SP_S1 = "key_1";
//    static String KEY_SP_S1_CELL_C1 = "s1_cell1";
//
//    View.OnClickListener listener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.sourceArrays:
//                    setCurrentSource(SOURCE_ARRAY);
//                    break;
//                case R.id.sourceSP:
//                    setCurrentSource(SOURCE_SP);
//                    break;
//                case R.id.sourceGF:
//                    setCurrentSource(SOURCE_GF);
//                    break;
//            }
//            setupSource();
//        }
//    };
//
//    void setCurrentSource(int currentSource) {
//        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(KEY_SP_S1, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(KEY_SP_S1_CELL_C1, currentSource);
//        editor.apply();
//    }
//
//    int getCurrentSource() {
//        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(KEY_SP_S1, Context.MODE_PRIVATE);
//        return sharedPreferences.getInt(KEY_SP_S1_CELL_C1, SOURCE_ARRAY);
//    }

