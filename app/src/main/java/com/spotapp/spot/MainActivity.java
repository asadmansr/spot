package com.spotapp.spot;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.next_btn);
        button.setOnClickListener(this);

        ((Button) findViewById(R.id.next_btn2)).setOnClickListener(this);

        final Handler handler = new Handler();
        final int delay = 2000; //milliseconds
        final MainActivity self = this;
        final Runnable runnable = new Runnable(){
            private boolean toggle = false;
            public void run() {
                //do something
                if(toggle) {
                    button.setBackground(getDrawable(R.drawable.buttondrawablenormal));
                    button.setTextColor(getResources().getColor(R.color.black));
                    button.setText(getResources().getText(R.string.add_or_refund_time));
                    button.setOnClickListener(self);
                } else {
                    button.setBackground(getDrawable(R.drawable.buttondrawable));
                    button.setTextColor(getResources().getColor(R.color.colorAccent));
                    button.setText(getResources().getText(R.string.insert_ticket_to_add_or_refund_time));
                    button.setOnClickListener(null);
                }

                toggle = !toggle;

                handler.postDelayed(this, delay);
            }
        };

        handler.postDelayed(runnable, delay);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.next_btn2:
                Intent intent = new Intent(MainActivity.this, PickParkingActivity.class);
                startActivity(intent);
                break;
            case R.id.next_btn:
                Intent intent2 = new Intent(MainActivity.this, EditTicketActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
