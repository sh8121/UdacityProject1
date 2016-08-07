package com.example.sboo.udacityproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View v){
        //displayPrice(quantity * 5);
        int price = quantity * 5;
        String message = "Total: $" + price;
        message = message + "\nThank you!";
        displayMessage(message);
    }

    public void increment(View v){
        quantity = quantity + 1;
        display(quantity);
        //displayPrice(numberOfCoffees * 5);
    }

    public void decrement(View v){
        quantity = quantity - 1;
        display(quantity);
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

    private void displayMessage(String message){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
