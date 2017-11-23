package com.spotapp.spot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class EditTicketActivity extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ticket);

        ((ProgressBar) findViewById(R.id.progressBar)).setProgress(40);

        ((Button) findViewById(R.id.next_btn2)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next_btn2:
                Intent intent = new Intent(EditTicketActivity.this, PickTimeActivity.class);
                startActivity(intent);
                break;
        }

    }
}
