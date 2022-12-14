package com.example.euroleagueapp_api29.ui;

import android.content.res.Resources;

import com.example.euroleagueapp_api29.R;
import com.example.euroleagueapp_api29.rep.CardData;
import com.example.euroleagueapp_api29.rep.CardSourse;

import java.util.ArrayList;
import java.util.List;

public class LocalRepImpl implements CardSourse {

    private List<CardData> dataSourse;
    private Resources resources;

    LocalRepImpl(Resources resources){
        dataSourse = new ArrayList<CardData>();
        this.resources = resources;
        }

    public LocalRepImpl init() {
        String[] titles = resources.getStringArray(R.array.games);
        //String[] predict = resources.getStringArray(R.array.games);

        for (int i = 0; i < titles.length; i++) {
            dataSourse.add(new CardData(titles[i])
                    //predict[i]));
            );
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
    public CardData getCardData(int position) {
        return dataSourse.get(position); // вернуть карточку по позиции
    }
}
