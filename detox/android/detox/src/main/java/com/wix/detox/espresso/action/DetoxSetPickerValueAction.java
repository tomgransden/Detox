package com.wix.detox.espresso.action;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import org.hamcrest.Matcher;

import java.lang.reflect.Method;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

public class DetoxSetPickerValueAction implements ViewAction {
    private final String value;

    public DetoxSetPickerValueAction(String value){
        this.value = value;
    }

    @Override
    public Matcher<View> getConstraints() {
        return allOf(isDisplayed(), withClassName(is("com.slimmingworld.datapicker.ui.NumberPicker")));
    }

    @Override
    public String getDescription() {
        return "Sets the value of a NumberPicker";
    }

    @Override
    public void perform(UiController uiController, View view) {
        try {
            Method getDisplayedValuesMethod = view.getClass().getMethod("getDisplayedValues");
            String[] pickerValues = (String[])getDisplayedValuesMethod.invoke(view);

            int index = -1;
            for(int i=0; i<pickerValues.length; i++){
                if(pickerValues[i].equals(value)){
                    index = i;
                    break;
                }
            }

            if(index == -1) throw new RuntimeException("Couldn't find value in Android picker");

            Class[] argumentTypes = {int.class, boolean.class};
            Method setValueMethod = view.getClass().getDeclaredMethod("setValueInternal", argumentTypes );
            setValueMethod.setAccessible(true);
            setValueMethod.invoke(view, index, true);
        }catch(Exception e){
            throw new RuntimeException("Unable to pick value in Android picker " + e.getMessage());
        }
    }
}
