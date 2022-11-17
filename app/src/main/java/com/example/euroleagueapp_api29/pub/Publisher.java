package com.example.euroleagueapp_api29.pub;
import com.example.euroleagueapp_api29.rep.CardData;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private final List<Observer> observers;
    public Publisher() { observers = new ArrayList<>(); }

    public void subscribe(Observer observer) { observers.add(observer); // добавить в подписки
    }
    public void unsubscribe(Observer observer) { observers.remove(observer); //удалить из подписки
    }
    public void sendMessage(CardData cardData){
//метод который будут вызывать другие классы и передавать что-то в него
    for(Observer observer:observers) {
        observer.receiveMessage(cardData);
        }
    }
}
