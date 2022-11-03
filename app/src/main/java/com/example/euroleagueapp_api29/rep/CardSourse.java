package com.example.euroleagueapp_api29.rep;

import com.example.euroleagueapp_api29.rep.CardData;

import java.util.List;

public interface CardSourse {
    int size();
    List<CardData> getAllCardsData();
    CardData getCardData(int position);
    void makePredict(int position, CardData newCardData);

}
