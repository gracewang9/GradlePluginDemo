package com.grace.gradleplugindemo;

import com.grace.gradleplugindemo.observers.ConcreteObserverOne;
import com.grace.gradleplugindemo.observers.ConcreteObserverTwo;
import com.grace.gradleplugindemo.observers.ConcreteSubject;
import com.grace.gradleplugindemo.observers.Message;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

}