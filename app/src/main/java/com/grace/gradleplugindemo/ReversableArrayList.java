package com.grace.gradleplugindemo;

import java.util.ArrayList;
import java.util.Collections;

public class ReversableArrayList<E> extends ArrayList<E> {

    public void reverse(){
        Collections.reverse(this);
    }
}
