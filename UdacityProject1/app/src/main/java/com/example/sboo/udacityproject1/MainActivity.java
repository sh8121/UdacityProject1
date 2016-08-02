package com.example.sboo.udacityproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View v){
        int numberOfCoffees = 2;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
    }

    public void increment(View v){
        int numberOfCoffees = 3;
        display(numberOfCoffees);
        //displayPrice(numberOfCoffees * 5);
    }

    public void decrement(View v){
        int numberOfCoffees = 1;
        display(numberOfCoffees);
        //displayPrice(numberOfCoffees);
    }

    private void display(int number){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


}
