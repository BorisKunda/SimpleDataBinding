package com.happytrees.simpledatabinding;

import android.databinding.ObservableInt;

public class Counter {

    private ObservableInt mCounterObservable = new ObservableInt();

    public ObservableInt getCounterObservable() {
        return mCounterObservable;
    }
}
