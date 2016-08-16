package com.example.sboo.udacityproject1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View v){
        //displayPrice(quantity * 5);

        CheckBox checkBox = (CheckBox)findViewById(R.id.topping_check_box);
        CheckBox toppingChocolateCheckBox = (CheckBox)findViewById(R.id.topping_chocolate);

        EditText nameEditText = (EditText)findViewById(R.id.name_edittext);
        boolean isChecked = checkBox.isChecked();
        boolean isChocolateCheckBoxChecked = toppingChocolateCheckBox.isChecked();

        int price = calculatePrice(isChecked, isChocolateCheckBoxChecked);
        String name = nameEditText.getText().toString();
        String message = createOrderSummary(price, isChecked, isChocolateCheckBoxChecked, name);
        displayMessage(name,message);
    }

    /**
     * Calculate the total Price
     *
     * @return the ordered price
     */
    private int calculatePrice(boolean isWhipeedChecked, boolean isChocolateChecked){
        int pricePerCup = 5;

        if(isWhipeedChecked){
            pricePerCup = pricePerCup + 1;
        }

        if(isChocolateChecked){
            pricePerCup = pricePerCup + 2;
        }

        int price = quantity * pricePerCup;
        return price;
    }

    /**
     * create the Order Summary text
     * @param price is the total Order Price
     * @param isChecked is the value of whether the topping is checked
     * @param isChocolateCheckBoxChecked is the value of whether the toppingChocolate is checked
     * @name is the value of name
     * @return the Order Summary Text
     */
    private String createOrderSummary(int price, boolean isChecked, boolean isChocolateCheckBoxChecked, String name){
        String message = "Name: " + name;
        message += ("\nAdd Whipped Cream? " + isChecked);
        message += "\nAdd Chocolate? " + isChocolateCheckBoxChecked;
        message += ("\nQuantity: " + quantity);
        message += ("\nTotal: $" + price);
        message += "\nThank you!";
        return message;
    }

    public void increment(View v){
        if(quantity >= 100){
            Toast.makeText(this, "You can order 100 coffees or less.", Toast.LENGTH_LONG).show();
            return;
        }

        quantity = quantity + 1;
        display(quantity);
        //displayPrice(numberOfCoffees * 5);
    }

    public void decrement(View v){
        if(quantity <= 1){
            Toast.makeText(this, "You can order at least 1 coffees.", Toast.LENGTH_LONG).show();
            return;
        }

        quantity = quantity - 1;
        display(quantity);
        //displayPrice(numberOfCoffees);
    }

    private void display(int number){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

//    private void displayPrice(int number){
//        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    private void displayMessage(String name, String message){
//        TextView orderSummaryTextView = (TextView)findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject, name));
        Toast.makeText(this,getString(R.string.subject, name), Toast.LENGTH_LONG).show();
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

}
