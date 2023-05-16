package com.hacktiv8.finalproject3kelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String operator = "+";
    Boolean newOperator = true;
    EditText inputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);

    }
    public void clickNumber (View view) {
        if (newOperator)
            inputNumber.setText("");
        newOperator = false;

        String number = inputNumber.getText().toString();
        switch (view.getId()) {
            case R.id.btn0:
                number += "0";
                break;
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btnDot:
                number += ".";
                break;
        }
        inputNumber.setText(number);
    }

    public void operatorClick (View view) {
        newOperator = true;
        oldNumber = inputNumber.getText().toString();

        switch (view.getId()){
            case R.id.btnDivide: operator = "/";
                break;

            case R.id.btnPlus: operator = "+";
                break;

            case R.id.btnMinus: operator = "-";
                break;

            case R.id.btnMultiple: operator = "*";
                break;
        }
    }

    public void deleteClick(View view) {
        inputNumber.setText("0");
        newOperator = true;

    }

    public void percentClick(View view) {
        double percent = Double.parseDouble(inputNumber.getText().toString())/100;
        inputNumber.setText(percent+"");
        newOperator = true;
    }

    public void equalClick (View view) {
        String newNumber = inputNumber.getText().toString();
        double result = 0.0;
        switch (operator) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
        } inputNumber.setText(result+"");

    }

}