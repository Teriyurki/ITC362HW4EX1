package com.example.mortgagecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage();
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateView();
    }

    private void updateView() {

        TextView amountTV = findViewById(R.id.TV_amount);
        amountTV.setText(mortgage.getFormattedAmount());
        TextView yearsTV = findViewById(R.id.TV_years);
        yearsTV.setText("" + mortgage.getYears());
        TextView rateTV = ( TextView ) findViewById( R.id.TV_rate );
        rateTV.setText( 100 * mortgage.getRate( ) + "%" );
        TextView monthlyTV = ( TextView ) findViewById( R.id.TV_payment );
        monthlyTV.setText( mortgage.formattedMonthlyPayment( ) );
        TextView totalTV = ( TextView ) findViewById( R.id.TV_total);
        totalTV.setText( mortgage.formattedTotalPayment( ) );

    }

    public void modifyData(View view) {

        Intent myintent = new Intent(this, DataActivity.class);
        this.startActivity(myintent);
        overridePendingTransition(R.anim.slide_from_left, 0);
    }
}