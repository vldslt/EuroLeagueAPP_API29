package com.example.euroleagueapp_api29.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.euroleagueapp_api29.R;
import com.example.euroleagueapp_api29.rep.CardData;
import com.example.euroleagueapp_api29.rep.CardSourse;
import com.example.euroleagueapp_api29.rep.OnItemClickListener;

public class PredictionAdapter extends RecyclerView.Adapter<PredictionAdapter.MyNewHolder> {

    private CardSourse cardSourse;

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;

    }
    public void setData(CardSourse cardSourse) {
        this.cardSourse = cardSourse;
        notifyDataSetChanged(); // команда адапретру - отрисовать все данные
    }

    PredictionAdapter(CardSourse cardSourse) {
        this.cardSourse = cardSourse;
    }
    PredictionAdapter(){}


    @NonNull
    @Override
    public MyNewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //создаёт зависимость viewholder и viewtype
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyNewHolder(layoutInflater.inflate(R.layout.fragment_prediction_cardview_item, parent, false));
        // return new MyNewHolder(layoutInflater.inflate(R.layout.fragment_prediction_cardview_item, parent, false));  --не рабоатет без замены в prediction fragment
    }

    @Override
    public void onBindViewHolder(@NonNull MyNewHolder holder, int position) { //связывает созданный viewholder с позицией
        holder.bindContentWithLayout(cardSourse.getCardData(position));
    }

    @Override
    public int getItemCount() {
        return cardSourse.size();
    }

    class MyNewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        //private TextView textViewPrediction;
        public MyNewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.game);
            //textViewPrediction = (TextView) itemView.findViewById(R.id.predict);
        }

        public void bindContentWithLayout(CardData content) { //связываем контент с макетом
            textViewTitle.setText(content.getTitle());
            //textViewPrediction.setText(content.getPredict());
        }
    }
}
