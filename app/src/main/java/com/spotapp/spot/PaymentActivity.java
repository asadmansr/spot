package com.spotapp.spot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getSupportActionBar().setTitle("Select a Payment Method");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView cardView = (CardView) findViewById(R.id.cash_cv);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, TicketActivity.class);
                startActivity(intent);
            }
        });
    }
}
