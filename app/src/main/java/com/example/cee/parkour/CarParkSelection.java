package com.example.cee.parkour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarParkSelection extends AppCompatActivity {

    Button btnSlot1;
    Button btnSlot2;
    Button btnPSlot1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_park_selection);

        btnSlot1 = (Button) findViewById(R.id.slot1);
        btnSlot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CarParkSelection.this, NormalZone_Slot1.class);
                startActivity(myIntent);
            }
        });

        btnSlot2 = (Button) findViewById(R.id.slot2);
        btnSlot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CarParkSelection.this, NormalZone_Slot2.class);
                startActivity(myIntent);
            }
        });

        btnPSlot1 = (Button) findViewById(R.id.pSlot1);
        btnPSlot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CarParkSelection.this, P60_Zone_Slot1.class);
                startActivity(myIntent);
            }
        });
    }
}
