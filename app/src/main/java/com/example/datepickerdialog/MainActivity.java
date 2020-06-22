package com.example.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView mTVDate;
    private Button mBSetDatePicker;

    private int year, month, day;

    private final int ID_DATE_PICKER_DIALOG = 1;

    private final String LOGS = "DatePicker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTVDate = (TextView) findViewById(R.id.mTVDate);
        mBSetDatePicker = (Button) findViewById(R.id.mBSetDatePicker);

        mBSetDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(ID_DATE_PICKER_DIALOG);
            }
        });
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            Log.d(LOGS, "Set new DatePicker");
            Log.d(LOGS, "Date - " + dayOfMonth + "." + month + "." + year);
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == ID_DATE_PICKER_DIALOG) {
            formDate();

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener, year, month - 1, day);

            datePickerDialog.show();

            return datePickerDialog;
        }
        return super.onCreateDialog(id);
    }

    private void formDate() {
        Date date = new Date();

        SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("dd");
        SimpleDateFormat simpleDateFormatMonth = new SimpleDateFormat("MM");
        SimpleDateFormat simpleDateFormatYear = new SimpleDateFormat("yyyy");

        year = Integer.parseInt(simpleDateFormatYear.format(date));
        month = Integer.parseInt(simpleDateFormatMonth.format(date));
        day = Integer.parseInt(simpleDateFormatDay.format(date));
    }
}