package com.maywzh.pattern.observer;

public class ObjectFor3D implements Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    private String msg;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observsers.remove(index);
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();
    }
}