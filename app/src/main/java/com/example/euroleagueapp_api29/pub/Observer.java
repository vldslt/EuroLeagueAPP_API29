package com.example.euroleagueapp_api29.pub;

import com.example.euroleagueapp_api29.rep.CardData;

public interface Observer {
    void receiveMessage(CardData cardData); //принимает в себя карточку
}
// тот, кто реализует у себя этот интерфейс + делает подписку,начинает принимать сообщения от паблишера
