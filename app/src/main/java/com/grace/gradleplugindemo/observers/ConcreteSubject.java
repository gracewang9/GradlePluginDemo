package com.grace.gradleplugindemo.observers;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    List<Observer> list = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).update(message);
        }
    }
}
