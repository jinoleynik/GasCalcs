package com.shz.gascalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements TextWatcher {

    private EditText mEdtPrice;
    private EditText mEdtTemperature;
    private EditText mEdtBaloonVolume;
    private EditText mEdtForSum;
    private TextView mEdtEndSumFull;
    private TextView mEdtEndSumSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtPrice = (EditText) findViewById(R.id.edt_price);
        mEdtTemperature = (EditText) findViewById(R.id.edt_temperature);
        mEdtBaloonVolume = (EditText) findViewById(R.id.edt_baloon_volume);
        mEdtForSum = (EditText) findViewById(R.id.edt_for_sum);
        mEdtEndSumFull = (TextView) findViewById(R.id.edt_end_full);
        mEdtEndSumSum = (TextView) findViewById(R.id.edt_end_for_value);

        mEdtForSum.addTextChangedListener(this);
        mEdtTemperature.addTextChangedListener(this);
        mEdtBaloonVolume.addTextChangedListener(this);
        mEdtPrice.addTextChangedListener(this);

    }

    private void calculate() {
        int temperature = 0;
        double price = 0;
        Log.d("mylog", mEdtPrice.getText().toString());
        Log.d("mylog", mEdtTemperature.getText().toString());
        if (!mEdtPrice.getText().toString().equals("")) {
            try{
                price = Double.parseDouble(mEdtPrice.getText().toString());
            }catch (NumberFormatException e){
                price = 0;
            }

        }
        if (!mEdtTemperature.getText().toString().equals(""))
            temperature = getTemperature();
        mEdtPrice.setText("value = "+price +" "+temperature);
    }

    int roundUp(int n) {
        return (n + 4) / 5 * 5;
    }

    private int getTemperature() {
        int temperature = Integer.parseInt(mEdtTemperature.getText().toString());
        if (temperature > 0) {
            temperature = roundUp(temperature);

        } else {
            temperature = -1 * roundUp(Math.abs(temperature));
        }
        return temperature;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        calculate();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
