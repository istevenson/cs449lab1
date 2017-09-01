package com.example.a449project.lab1umpirebuddy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // initialize balls and strike counts
    private int ballCount = 0;
    private int strikeCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set ball and strike buttons from view
        View ballButton = findViewById(R.id.ballButton);
        ballButton.setOnClickListener(this);

        View strikeButton = findViewById(R.id.strikeButton);
        strikeButton.setOnClickListener(this);

        // update counts to display
        updateCountsToView();

    }

    private void resetCounts() {
        ballCount = 0;
        strikeCount = 0;
    }

    private void updateCountsToView() {
        // ball count to view
        TextView balls = (TextView)findViewById(R.id.ballCount);
        balls.setText(Integer.toString(ballCount));

        // strike count from view
        TextView strikes = (TextView)findViewById(R.id.strikeCount);
        strikes.setText(Integer.toString(strikeCount));
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ballButton:
                ballAction();
                break;
            case R.id.strikeButton:
                strikeAction();
                break;
        }

    }

    public void ballAction() {
        ballCount++;
        if (ballCount >=4) {
            walkBatter();
        }

        updateCountsToView();
    }

    public void strikeAction() {
        strikeCount++;
        if (strikeCount >=3) {
            outBatter();
        }

        updateCountsToView();
    }

    public void walkBatter() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("That's a walk!");
        alert.setCancelable(false);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                resetCounts();
                updateCountsToView();
            }
        });
        alert.show();
    }

    public void outBatter() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("That's an out!");
        alert.setCancelable(false);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                resetCounts();
                updateCountsToView();
            }
        });
        alert.show();
    }
}
