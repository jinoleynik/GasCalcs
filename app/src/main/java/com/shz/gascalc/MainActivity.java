package com.shz.gascalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText mEdtPrice;
    private EditText mEdtTemperature;
    private EditText mEdtBaloonVolume;
    private Spinner mSpinnerTemperature;
    private Spinner mSpinnerOstValue;
    private TextView mTvEndFullPrice;
    private TextView mTvEndFullValue;
    private EditText mMoneyValue;
    private TextView mTvEndMoneyOst;
    private TextView mTvEndMoneyValue;
    private TextView mTvAlert;
    private static boolean isDebug = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtPrice = (EditText) findViewById(R.id.edt_price);
        mEdtBaloonVolume = (EditText) findViewById(R.id.edt_baloon_volume);


        mSpinnerTemperature = (Spinner) findViewById(R.id.temp_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_spinner, Constants.TEMP_MAP);
        adapter.setDropDownViewResource(R.layout.item_spinner);
        mSpinnerTemperature.setAdapter(adapter);
        mSpinnerTemperature.setPrompt(getString(R.string.temperatura));
        mSpinnerTemperature.setSelection(3);
        mSpinnerOstValue = (Spinner) findViewById(R.id.ost_volume_spinner);
        ArrayAdapter<String> adapterOst = new ArrayAdapter<String>(this, R.layout.item_spinner, Constants.OST_VALUE_MAP);
        adapter.setDropDownViewResource(R.layout.item_spinner);
        mSpinnerOstValue.setAdapter(adapterOst);
        mSpinnerOstValue.setPrompt(getString(R.string.ost_value));
        mSpinnerOstValue.setSelection(0);
        mTvEndFullPrice = (TextView) findViewById(R.id.edt_end_full_price);
        mTvEndFullValue = (TextView) findViewById(R.id.edt_end_full_value);
        findViewById(R.id.calculate).setOnClickListener(this);
        mMoneyValue = (EditText) findViewById(R.id.edt_money_value);

        mTvEndMoneyOst = (TextView) findViewById(R.id.edt_end_money_ost);
        mTvEndMoneyValue = (TextView) findViewById(R.id.edt_end_money_value);
        mTvAlert = (TextView) findViewById(R.id.tv_alert);
        if (isDebug) {
            mEdtBaloonVolume.setText("65");
            mEdtPrice.setText("9");
            mMoneyValue.setText("100");
        }
    }
//    16,458

    private void calculate() {
//        int temperature = 0;
        double price = 0;
        String valuePrice = mEdtPrice.getText().toString().trim();
        String baloonValue = mEdtBaloonVolume.getText().toString().trim();
        String temperature = mSpinnerTemperature.getSelectedItem().toString();
        Double[] curValues = Constants.TEMPERATURE_MAP.get(temperature);
        Double ostValue = curValues[mSpinnerOstValue.getSelectedItemPosition()];
        int baloonVal = 0;
        if (!baloonValue.isEmpty())
            baloonVal = Integer.parseInt(baloonValue);

        double fullValue = curValues[curValues.length - 1] * baloonVal - baloonVal * ostValue;

        if (!valuePrice.isEmpty()) {
            price = Double.parseDouble(valuePrice);
        }
        double fullValuePrice = price * fullValue;
        mTvEndFullPrice.setText(String.format("%.2f", fullValuePrice));
        mTvEndFullValue.setText(String.format("%.2f", fullValue));


        String priceValue = mMoneyValue.getText().toString().trim();
        int money = 0;
        if (!priceValue.isEmpty()) {
            money = Integer.parseInt(priceValue);

            double ostMoneyValue = money / price / baloonVal + ostValue;
            mTvEndMoneyValue.setText(String.format("%.2f", (float) money / price));
            for (int i = 0; i < curValues.length; i++) {
                double val1 = curValues[i];
                double nextVal = 1;
                if (i < curValues.length - 1) {
                    nextVal = curValues[i + 1];
                }
                if (ostMoneyValue >= val1 && ostMoneyValue <= nextVal) {
                    int v1 = i * 10 + 10;
                    double v2 = (nextVal - val1) / 10;
                    while (val1 < ostMoneyValue) {
                        v1++;
                        val1 += v2;
                    }
                    Log.d("mylog", "value = " + val1 + "   " + v1);
                    mTvEndMoneyOst.setText(String.valueOf(v1));
                }

            }

        }
        mTvAlert.setVisibility(money > fullValuePrice ? View.VISIBLE : View.GONE);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calculate:
                calculate();
                break;
        }
    }
}
