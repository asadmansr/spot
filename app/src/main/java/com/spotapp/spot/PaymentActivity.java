package com.spotapp.spot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;

public class PaymentActivity extends AppCompatActivity {

    boolean isCashHidden = true;
    boolean isDebitHidden = true;
    boolean isCreditHidden = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getSupportActionBar().setTitle("Select a Payment Method");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView cash_cardView = (CardView) findViewById(R.id.cash_cv);
        CardView debit_cardView = (CardView) findViewById(R.id.debit_cv);
        CardView credit_cardView = (CardView) findViewById(R.id.credit_cv);

        final RelativeLayout cash_detail = (RelativeLayout) findViewById(R.id.cash_rl);
        final RelativeLayout debit_detail = (RelativeLayout) findViewById(R.id.debit_rl);
        final RelativeLayout credit_detail = (RelativeLayout) findViewById(R.id.credit_rl);

        cash_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCashHidden){
                    cash_detail.setVisibility(View.VISIBLE);
                } else {
                    cash_detail.setVisibility(View.GONE);
                }

                isCashHidden = !isCashHidden;
            }
        });

        debit_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDebitHidden){
                    debit_detail.setVisibility(View.VISIBLE);
                } else {
                    debit_detail.setVisibility(View.GONE);
                }

                isDebitHidden = !isDebitHidden;

            }
        });

        credit_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCreditHidden){
                    credit_detail.setVisibility(View.VISIBLE);
                } else {
                    credit_detail.setVisibility(View.GONE);
                }

                isCreditHidden = !isCreditHidden;
            }
        });

    }
}
