package com.example.euroleagueapp_api29.rep;

import android.content.res.Resources;

import com.example.euroleagueapp_api29.R;

import java.util.ArrayList;
import java.util.List;

public class LocalRepImpl implements CardSourse {

    private List<CardData> dataSourse;
    private Resources resources;

    public LocalRepImpl(Resources resources){
        dataSourse = new ArrayList<CardData>();
        this.resources = resources;
        }

    public LocalRepImpl init() {
        String[] titles = resources.getStringArray(R.array.games);
        String[] predict = resources.getStringArray(R.array.forecast_stub);
        for (int i = 0; i < titles.length; i++) {
            dataSourse.add(new CardData(titles[i],predict[i]));
        }
        return this;
    }

    @Override
    public int size() {
        return dataSourse.size(); // вернуть размер
    }

    @Override
    public List<CardData> getAllCardsData() {
        return dataSourse; // вернуть список
    }

    @Override
    public CardData getCardData(int position) { return dataSourse.get(position); // вернуть карточку по позиции
    }

    @Override
    public void addCardData(CardData cardData) {
        dataSourse.add(cardData);
    }

    @Override
    public void makePredict(int position, CardData newCardData) {
        dataSourse.set(position, newCardData);
    }
}
