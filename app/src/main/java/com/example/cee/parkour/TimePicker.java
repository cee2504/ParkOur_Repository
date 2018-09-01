package com.example.cee.parkour;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.StringTokenizer;

public class TimePicker extends AppCompatActivity {

    TextView displayTime;
    TextView viewtimePicker;
    TextView timeTotal;
    EditText durationHour;


    static Dialog d;
    Button timeBtn;
    Button bookParking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        Calendar cal = Calendar.getInstance();
        final int curHour = cal.get(Calendar.HOUR_OF_DAY);
        int curMinute = cal.get(Calendar.MINUTE);

        String curTime = curHour + ":" + curMinute;

        displayTime = (TextView) findViewById(R.id.curTime);
        displayTime.setText(curTime);

        timeBtn = (Button) findViewById(R.id.btnTime);
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewtimePicker = (TextView) findViewById(R.id.viewTime);
                final Dialog d = new Dialog(TimePicker.this);
                d.setTitle("NumberPicker");
                d.setContentView(R.layout.dialog);

                Button b1 = (Button) d.findViewById(R.id.button1);

                final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
                np.setMaxValue(24);
                np.setMinValue(0);
                np.setWrapSelectorWheel(false);

                b1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        //if (hour > curHour) {      //Compare current time with input time
                            if ((np.getValue() >=12) && (np.getValue() <14)){
                                viewtimePicker.setText("This time is booked");
                                d.dismiss();
                            }
                            else if (np.getValue() == 16){
                                viewtimePicker.setText("This time is booked");
                                d.dismiss();
                            }
                            else if (np.getValue() >= 17 ){
                                viewtimePicker.setText("Parking is free from 17:00 from 9:00. No booking required");
                                d.dismiss();
                            }
                            else {
                                viewtimePicker.setText(String.valueOf(np.getValue() + ":00"));
                                d.dismiss();
                            }
                            // }
                        /*else if ( hour < curHour){
                            viewtimePicker.setText("Time invalid. Time must be equal or greater than current time");
                        }*/

                    }
                });
                d.show();


            }
        });


        bookParking = (Button) findViewById(R.id.book);
        bookParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hour ="";
                //String minute ="";
                timeTotal = (TextView) findViewById(R.id.totalTime);
                String[] time = viewtimePicker.getText().toString().split(":");
                for (int i = 0; i < time.length; i++){
                    hour = time[0];
                   // minute = time[1];
                    }

                durationHour = (EditText) findViewById(R.id.duration);
                int setHour = Integer.parseInt(hour);
                int setDuration = Integer.parseInt(durationHour.getText().toString());
                int totalHourBook = setHour + setDuration;


                if (( setHour < 12) && (totalHourBook >=12)){
                    timeTotal.setText("This time is booked");
                }
                if (( setHour == 15 ) && (totalHourBook >=17)){
                    timeTotal.setText("This time is booked");
                }
                else if (totalHourBook == 16){
                    timeTotal.setText("This time is booked");
                }
                else if ( (totalHourBook >= 17) && (totalHourBook <= 24)){
                    timeTotal.setText("Parking is free from 17:00 from 9:00. No booking required");
                }
                else if (totalHourBook > 24 ){
                    timeTotal.setText("Invalid Time. Enter again");
                }
                else if (totalHourBook < 9  ){
                    timeTotal.setText("Parking is free from 17:00 from 9:00. No booking required");
                }
                else if (( setHour < 9) && (totalHourBook >= 9) ){
                    int price = (setDuration - ( 9 - setHour )) * 20;
                    timeTotal.setText("Normal Zone - $20/hour \n" +
                            "Your Booking: \n"+
                            "From: "+ viewtimePicker.getText().toString() +"\n"+
                            "To: "+Integer.toString(totalHourBook) + ":00" +"\n"+
                            "Total Price($): " + Integer.toString(price));
                }
                else {
                    int price = setDuration * 20;
                    timeTotal.setText("Normal Zone - $20/hour \n" +
                            "Your Booking: \n"+
                            "From: "+ viewtimePicker.getText().toString() +"\n"+
                            "To: "+Integer.toString(totalHourBook) + ": 00"+"\n"+
                            "Total Price($): " + Integer.toString(price));
                }



                //timeTotal.setText(Integer.toString(Integer.parseInt(hour) +  Integer.parseInt(durationHour.getText().toString())));
            }
        });
    }
}
