package com.example.a449project.lab1umpirebuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        // set counts
        setBalls();
        setStrikes();

    }

    private void setBalls() {
        // ball count from view
        TextView count = (TextView)findViewById(R.id.ballCount);
        count.setText(Integer.toString(ballCount));
    }

    private void setStrikes() {
        // strike count from view
        TextView count = (TextView)findViewById(R.id.strikeCount);
        count.setText(Integer.toString(strikeCount));
    }

    @Override
    public void onClick(View view){

    }
}
