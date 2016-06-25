package com.codepath.nytimessearch.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.codepath.nytimessearch.DatePickerFragment;
import com.codepath.nytimessearch.R;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by mbytsang on 6/23/16.
 */

//Contains filters to be applied at any time
public class SearchFilters extends DialogFragment implements View.OnClickListener{
    private FragmentManager supportFragmentManager;
    private SearchFilters mFilters;


/*
    String begin_date;
    String sort;
    String news_desk;
    */

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Activity needs to implement this interface
        DatePickerDialog.OnDateSetListener listener = (DatePickerDialog.OnDateSetListener) getActivity();

        // Create a new instance of TimePickerDialog and return it
        return new DatePickerDialog(getActivity(), listener, year, month, day);
    }

    // attach to an onclick handler to show the date picker
    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    // handle the date selected
    //@Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // store the values selected into a Calendar instance
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }

    public FragmentManager getSupportFragmentManager() {
        return supportFragmentManager;
    }

    // SearchFiltersDialogFragment.newInstance(filters);
    public static DatePickerFragment newInstance(SearchFilters filters) {
        DatePickerFragment frag = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putSerializable("filters", (Serializable) filters);
        // or putParcelable(...) and then later getParcelable(...)
        frag.setArguments(args);
        return frag;
    }

    // 1. Defines the listener interface with a method
    //    passing back filters as result.
    public interface OnFilterSearchListener {
        void onUpdateFilters(SearchFilters filters);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Store the filters to a member variable
        mFilters = (SearchFilters) getArguments().getSerializable("filters");
        // ... any other view lookups here...
        // Get access to the button
        Button btnSave =(Button) view.findViewById(R.id.dateButton);
        // 2. Attach a callback when the button is pressed
        btnSave.setOnClickListener(this);
    }

    // This is fired the button in the activity is clicked
    // This is the time to apply the filters by
    // sending back to the search activity
    @Override
    public void onClick(View v) {
        // Update the mFilters based on the input views
        // ...
        // Return filters back to activity through the implemented listener
        OnFilterSearchListener listener = (OnFilterSearchListener) getActivity();
        listener.onUpdateFilters(mFilters);
        // Close the dialog to return back to the parent activity
        dismiss();
    }



}
