package com.a5835512100.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText myEditText;
    private TextView myTextView,myTextTitle;
    private double val,cal;
    private String aus,subfix;
    private RadioButton tof,toc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = findViewById(R.id.editText1);
        myTextTitle = findViewById(R.id.textView1);
        tof = findViewById(R.id.radio_pirates);
        toc = findViewById(R.id.radio_ninjas);
        tof.setChecked(true);

        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myTextView = findViewById(R.id.textView2);
                if (s.length() != 0) {
                    val = Double.parseDouble(s.toString());
                    if (tof.isChecked()){
                        subfix = " ํF";
                        myTextTitle.setText("fahrenheit");
                        cal = (val * 1.8) + 32;
                    }else {
                        subfix = " ํC";
                        myTextTitle.setText("celsius");
                        cal = (val - 32) / 1.8;
                    }
                    myTextView.setText(aus.format("%.2f", cal) + subfix);
                }else {
                    myTextView.setText(" ");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
