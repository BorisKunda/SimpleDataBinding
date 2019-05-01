package com.happytrees.simpledatabinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

public class Person extends BaseObservable {

    /**
     * in order to allow binding object access model instances you
     * must make your properties public or provide public getters
     */

    /**
     * To make the object observable, extend the class from BaseObservable.
     * <p>
     * To make a property observable, use @Bindable annotation on getter method.
     * Call notifyPropertyChanged(BR.property) in setter method to update the UI whenever the data is changed.
     */

    private String name;
    private String lastName;
    private String thirdName;
    private ObservableBoolean observableBoolean = new ObservableBoolean();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;

    }

    @Bindable
    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
        notifyPropertyChanged(BR.thirdName);
    }

    public ObservableBoolean getObservableBoolean() {
        return observableBoolean;
    }

}
