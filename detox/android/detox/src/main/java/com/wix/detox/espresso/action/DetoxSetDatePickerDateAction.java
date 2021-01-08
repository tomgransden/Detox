package com.wix.detox.espresso.action;

import android.view.View;
import android.widget.DatePicker;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import org.hamcrest.Matcher;

import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.allOf;

public class DetoxSetDatePickerDateAction implements ViewAction {

    private final int day;
    private final int month;
    private final int year;

    public DetoxSetDatePickerDateAction(int day, int month, int year){
        this.day = day;
        this.month = month - 1;
        this.year = year;
    }

    @Override
    public Matcher<View> getConstraints() {
        return allOf(isDisplayed(), isAssignableFrom(DatePicker.class));
    }

    @Override
    public String getDescription() {
        return "Sets the date of an Android date picker";
    }

    @Override
    public void perform(UiController uiController, View view) {

    }
}
