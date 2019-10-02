package com.example.currencyconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final double USDTOEGPRATE = 16.5;
    final String USDTOEGPSTRING = "EGP";
    final String EGPTOUSDSTRING = "USD";
    final double EGPTOUSDRATE = 1 / USDTOEGPRATE;
    TextView result;
    EditText egp;
    EditText usd;
    void setResult(String text, double rate, String cur){
            double value;
            try{
                value = Double.parseDouble(text);
            }catch (Exception e){result.setText("0.0");return;}
            Double res = rate * value;
            result.setText(res.toString() + " "+cur);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        egp = findViewById(R.id.egpfield);
        usd = findViewById(R.id.usdfield);
        usd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String val = editable.toString();
                setResult(val,USDTOEGPRATE, USDTOEGPSTRING);
            }
        });
        egp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String val = editable.toString();
                setResult(val,EGPTOUSDRATE, EGPTOUSDSTRING);
            }
        });
    }
}
