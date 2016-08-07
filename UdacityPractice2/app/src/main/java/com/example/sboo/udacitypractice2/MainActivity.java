package com.example.sboo.udacitypractice2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int weekday = 5;
        int weekend = 9;
        int optimalHours = 7 * 8;
        int actualHours = weekday * 5;
        actualHours = actualHours + weekend * 2;
        int solution = optimalHours - actualHours;
        display(solution);
    }

    private void display(int number){
        TextView sleepTextView = (TextView)findViewById(R.id.sleep_text_view);
        sleepTextView.setText("" + number);
    }
}
