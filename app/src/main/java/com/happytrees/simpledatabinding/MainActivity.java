package com.happytrees.simpledatabinding;

//import android.databinding.DataBindingUtil;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.happytrees.simpledatabinding.databinding.ActivityMainBinding;

//good example : //https://www.androidhive.info/android-working-with-databinding/

public class MainActivity extends AppCompatActivity {

    private int temp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sets content view + inflates the binding layout using the generated binding class
        //ActivityMain binding is generated binding class - its name generates as layout name converted to camel case + Binding suffix
        final ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        /**regular data binding
         * model sets view
         *
         * observable data binding
         * changing model updates view
         *
         * two way data binding
         * changes in view update
         * model +
         * changes in model update view
         *
         */




        final Person p = new Person();
        final Counter counter = new Counter();
        MyClickHandlers myClickHandlers = new MyClickHandlers(this, activityMainBinding);

        p.setName("Text1 set by data binding");
        p.setLastName("Text2 set by data binding");
        p.setThirdName("Text3");

        //binds the objects to view and sets bound view attributes according to object's properties.
        activityMainBinding.setHandlers(myClickHandlers);
        activityMainBinding.setPerson(p);
        activityMainBinding.setCounter(counter);

        //regular click listener won't work because of data binding
        p.getObservableBoolean().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Toast.makeText(MainActivity.this, "value  p.getObservableBoolean() : " +  p.getObservableBoolean().get(),
                Toast.LENGTH_SHORT).show();//p.getObservableBoolean().get() "get()" gets boolean value
            }
        });


        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setName("Text1 updated by activityMainBinding.setObject(o)");
                activityMainBinding.setPerson(p);//sets bound view attributes according to object's properties.
                Toast.makeText(MainActivity.this, "normal button", Toast.LENGTH_SHORT).show();
            }
        });


        //you can access every bound's layout view by id without using findViewById
        activityMainBinding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "forget findViewById", Toast.LENGTH_SHORT).show();
            }
        });

        activityMainBinding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp++;
                counter.getCounterObservable().set(temp);

            }
        });

        activityMainBinding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setThirdName("Text3 new Text");
            }
        });


    }

}
