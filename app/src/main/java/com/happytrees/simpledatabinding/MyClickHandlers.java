package com.happytrees.simpledatabinding;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.happytrees.simpledatabinding.databinding.ActivityMainBinding;

//To bind a click event, you need to create a class with necessary callback methods.
public class MyClickHandlers {

    private Context mContext;
    private ActivityMainBinding mActivityMainBinding;

    public MyClickHandlers(Context context, ActivityMainBinding activityMainBinding) {
        mContext = context;
        mActivityMainBinding = activityMainBinding;
    }

    public void onButtonClicked(View view) {//have to add view argument cause this method referenced in android:onClick in xml
        Toast.makeText(mContext, "bound button pressed", Toast.LENGTH_SHORT).show();
    }

    public void onButton2Clicked(View view, Person person) {
        person.setName("Text from bound button with arguments");
        mActivityMainBinding.setPerson(person);
    }

    //To assign long press event, the method should return boolean type instead of void
    public boolean onButtonLongPressed(View view) {
        Toast.makeText(mContext, "bound button long pressed", Toast.LENGTH_SHORT).show();
        return true;
    }



}
