package com.demo.android.bmi_4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Bmi extends AppCompatActivity implements View.OnClickListener {

    EditText field_height;
    EditText field_weight;
    TextView result;
    TextView suggest;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bmi);
        findViews();
        setListeners();
    }

    private void findViews(){
        submit = findViewById(R.id.submit);
        field_height = findViewById(R.id.field_height);
        field_weight = findViewById(R.id.field_weight);
        result = findViewById(R.id.result);
        suggest = findViewById(R.id.suggest);
    }

    private void setListeners(){
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double height = Double.parseDouble(field_height.getText().toString())/100;
        double weight = Double.parseDouble(field_weight.getText().toString());
        double bmi = weight / ( height * height ) ;

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("height = " + height);
        System.out.println("weight = " + weight);

        result.setText("您的BMI值為 " + df.format(bmi));

        if(bmi > 25){
            suggest.setText(R.string.advice_heavy);
        }
        else if(bmi < 20){
            suggest.setText(R.string.advice_light);
        }
        else{
            suggest.setText(R.string.advice_average);
        }
    }
}


