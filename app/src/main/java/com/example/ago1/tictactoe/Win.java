package com.example.ago1.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Win extends AppCompatActivity {


    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        t1= (TextView)  findViewById(R.id.textView3) ;

        Bundle b = getIntent().getExtras();
        int w = b.getInt("winner");

        if (w==0)
            t1.setText("Player O wins !!");
        else if (w==1)
            t1.setText("Player X wins !!");
        else
            t1.setText("No one Wins !!");


    }
}
