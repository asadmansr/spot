package com.spotapp.spot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PickParkingActivity extends AppCompatActivity {

    ImageView car1;
    ImageView car2;
    ImageView car3;
    ImageView car4;
    ImageView car5;
    ImageView car6;
    ImageView car7;
    ImageView car8;
    ImageView[] cars;
    boolean spotPicked = false;
    int numOfSpots = 8;
    boolean[] occupied = new boolean[8];
    public int parkingLotNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_parking);

        car1 = (ImageView) findViewById(R.id.car1);
        car2 = (ImageView) findViewById(R.id.car2);
        car3 = (ImageView) findViewById(R.id.car3);
        car4 = (ImageView) findViewById(R.id.car4);
        car5 = (ImageView) findViewById(R.id.car5);
        car6 = (ImageView) findViewById(R.id.car6);
        car7 = (ImageView) findViewById(R.id.car7);
        car8 = (ImageView) findViewById(R.id.car8);


        occupied[6] = true;
        occupied[7] = true;


        cars = new ImageView[] {car1, car2, car3, car4, car5, car6, car7, car8};

        refreshParking();
        car1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (car1.getAlpha() > 0.0f) {

                    car1.setAlpha(0.0f);
                } else {
                    car1.setAlpha(1.0f);
                }

            }
        });

        createListener(car1, 1);
        createListener(car2, 2);
        createListener(car3, 3);
        createListener(car4, 4);
        createListener(car5, 5);
        createListener(car6, 6);
        createListener(car7, 7);
        createListener(car8, 8);


    }

    public void refreshParking() {

        for (int i = 0; i < numOfSpots; i++) {
            if (occupied[i]) {
                cars[i].setImageResource(R.drawable.redcar);
            } else {
                cars[i].setAlpha(0.0f);
            }
        }

    }

    public void spotPicked() {

        Button button = (Button) findViewById(R.id.next_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PickParkingActivity.this, PickTimeActivity.class);
                startActivity(intent);
            }
        });

        button.setTextColor(getResources().getColor(R.color.black));

        button.setBackground(getDrawable(R.drawable.buttondrawablenormal));
        button.setText(getResources().getText(R.string.goToNextScreen));

    }

    public void createListener(final ImageView img, final int parkingLotNum) {
        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (img.getAlpha() == 0.0f) {

                    parkingLotNumber = parkingLotNum;
                    //System.out.println(parkingLotNumber);

                    if (spotPicked == false) {
                        spotPicked = true;
                        spotPicked();
                    }

                    refreshParking();
                    img.setImageResource(R.drawable.greencar);
                    img.setAlpha(1.0f);


                }

            }
        });

    }
}
