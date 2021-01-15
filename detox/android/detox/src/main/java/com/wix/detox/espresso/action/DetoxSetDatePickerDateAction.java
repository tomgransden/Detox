package com.wix.detox.espresso.action;

import android.view.View;
import android.widget.DatePicker;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import com.wix.detox.common.DetoxErrors;

import org.hamcrest.Matcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.allOf;

public class DetoxSetDatePickerDateAction implements ViewAction {

    private final String date;
    private final String format;

    public DetoxSetDatePickerDateAction(String date, String format){
        this.date = date;
        this.format = format;
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
        Date d;
        try {
            d = new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            throw new DetoxErrors.DetoxRuntimeException("Unable to parse date with format");
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        final DatePicker datePicker = (DatePicker) view;
        datePicker.updateDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
    }
}
