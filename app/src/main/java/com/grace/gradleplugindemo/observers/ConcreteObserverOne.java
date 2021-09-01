package com.grace.gradleplugindemo.observers;

public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne 收到消息");
    }
}
