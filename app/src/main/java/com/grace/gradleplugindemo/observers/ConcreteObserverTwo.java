package com.grace.gradleplugindemo.observers;

public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo 收到消息");
    }
}
