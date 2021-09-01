package com.grace.gradleplugindemo;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.AppCompatTextView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import com.grace.gradleplugindemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayList<? extends View> views=new ArrayList<TextView>();
//        ArrayList<? super AppCompatTextView> textViews=new ArrayList<TextView>();

    }

    public void jumpSecond(View view) {
        startActivity(new Intent(this,SecondActivity.class));
        AppleArrayList apples=new AppleArrayList();
        apples.add(new Apple());

//        Eater eater=new Eater<String>() {
//            @Override
//            public void eat(String food) {
//
//            }
//        };
    }
}