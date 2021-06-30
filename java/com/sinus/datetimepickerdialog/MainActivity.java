package com.sinus.datetimepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonTgl, buttonWkt;
    EditText textTgl, textWkt;

    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTgl = (Button) findViewById(R.id.button1);
        buttonWkt = (Button) findViewById(R.id.button2);

        textTgl = (EditText) findViewById(R.id.editText1);
        textWkt = (EditText) findViewById(R.id.editText2);

        buttonTgl.setOnClickListener(this);
        buttonWkt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonTgl) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    textTgl.setText(dayOfMonth + "-" + (monthOfYear +1)+"-"+year);
                }
            }, mYear, mMonth, mDay);
            dpd.show();
        }

        if (v == buttonWkt) {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    textWkt.setText(hourOfDay+":"+minute);
                }
            }, mHour, mMinute, false);
            tpd.show();
        }
    }
}