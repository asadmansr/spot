package com.spotapp.spot;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PickTimeActivity extends AppCompatActivity implements TimeDialogFragment.TimeDialogListener{

    TextView mStartTime;
    TextView mEndTime;
    TextView mDuration;
    TextView mTotalCost;
    FloatingActionButton mPaymentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_time);

        getSupportActionBar().setTitle("Select a Time");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mStartTime = (TextView) findViewById(R.id.start_time_tv);
        mEndTime = (TextView) findViewById(R.id.end_time_tv);
        mDuration = (TextView) findViewById(R.id.duration_time_tv);
        mTotalCost = (TextView) findViewById(R.id.total_cost_tv);
        mPaymentButton = (FloatingActionButton) findViewById(R.id.payment_btn);

        mStartTime.setText(getCurrentTime());

        mEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeDialogFragment timeDialogFragment = new TimeDialogFragment();
                timeDialogFragment.show(getSupportFragmentManager(), "MainActivity.TimeDialog");
            }
        });

        mPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PickTimeActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFinishDialog(String time) {
        //Toast.makeText(this, "Selected Date :"+ formatDate(date), Toast.LENGTH_SHORT).show();
    }

    private String getCurrentTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
        String startTimeString = dateFormat.format(new Date());
        return startTimeString;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
