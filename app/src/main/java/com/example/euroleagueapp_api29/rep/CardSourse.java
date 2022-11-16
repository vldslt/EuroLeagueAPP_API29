package com.example.euroleagueapp_api29.rep;

import java.util.List;

public interface CardSourse {
    int size();
    List<CardData> getAllCardsData();
    CardData getCardData(int position);

    void addCardData(CardData cardData); //меню(нет)

    void makePredict(int position, CardData newCardData); //контекстное

}
