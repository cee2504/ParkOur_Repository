package com.example.cee.parkour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class CarParkSelection extends AppCompatActivity {

    Button btnSlot1;
    Button btnSlot2;
    Button btnPSlot1;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_park_selection);

        //Firebase Code + Toolbar--------------
        firebaseAuth = FirebaseAuth.getInstance();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Car Park Selection");
        //-------------------------------------

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

//------------------------------------------------------------------------------------
//Firebase Code for toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.logoutMenu:
                Logout();

        }
        return super.onOptionsItemSelected(item);
    }

    //inflates the toolbar menu and populates it with all of its options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_parkour, menu);
        return true;
    }

   // Logs the user out
    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(CarParkSelection.this, LoginPage.class));
    }
//------------------------------------------------------------------------------------

}
