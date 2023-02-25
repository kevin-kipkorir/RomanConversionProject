package com.example.romanconversionproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button submitr,submit;
    EditText rom_input, decimal_input;
    TextView rom_output, decimal_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=findViewById(R.id.btn_submit);
        rom_input=findViewById(R.id.roman_editText);
        decimal_input=findViewById(R.id.interger_editText);
        rom_output=findViewById(R.id.solution_roman);
        decimal_output=findViewById(R.id.solution_decimal);
        submitr=findViewById(R.id.btn_submit_dec);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                convertToDecimal();
            }
        });

        submitr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                convertToRoman();
            }
        });

    }

    public void convertToDecimal() {
        EditText romanInput = findViewById(R.id.roman_editText);
        String roman = romanInput.getText().toString().toUpperCase();

        int decimal = 0;

        for (int i = 0; i < roman.length(); i++) {
            char letter = roman.charAt(i);
            int value = getDecimalValue(letter);

            if (i + 1 < roman.length()) {
                char nextLetter = roman.charAt(i + 1);
                int nextValue = getDecimalValue(nextLetter);

                if (nextValue > value) {
                    decimal -= value;
                } else {
                    decimal += value;
                }
            } else {
                decimal += value;
            }
        }

        TextView decimalOutput = findViewById(R.id.solution_decimal);
        decimalOutput.setText(String.valueOf(decimal));
    }

    public void convertToRoman() {
        EditText decimalInput = findViewById(R.id.interger_editText);
        int decimal = Integer.parseInt(decimalInput.getText().toString());

        String roman = "";

        while (decimal > 0) {
            if (decimal >= 1000) {
                roman += "M";
                decimal -= 1000;
            } else if (decimal >= 900) {
                roman += "CM";
                decimal -= 900;
            } else if (decimal >= 500) {
                roman += "D";
                decimal -= 500;
            } else if (decimal >= 400) {
                roman += "CD";
                decimal -= 400;
            } else if (decimal >= 100) {
                roman += "C";
                decimal -= 100;
            } else if (decimal >= 90) {
                roman += "XC";
                decimal -= 90;
            } else if (decimal >= 50) {
                roman += "L";
                decimal -= 50;
            } else if (decimal >= 40) {
                roman += "XL";
                decimal -= 40;
            } else if (decimal >= 10) {
                roman += "X";
                decimal -= 10;
            } else if (decimal >= 9) {
                roman += "IX";
                decimal -= 9;
            } else if (decimal >= 5) {
                roman += "V";
                decimal -= 5;
            } else if (decimal >= 4) {
                roman += "IV";
                decimal -= 4;
            } else {
                roman += "I";
                decimal--;
            }
        }

        TextView romanOutput = findViewById(R.id.solution_roman);
        romanOutput.setText(roman);
    }

    private int getDecimalValue(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
