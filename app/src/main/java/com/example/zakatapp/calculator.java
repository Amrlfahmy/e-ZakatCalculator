package com.example.zakatapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class calculator extends AppCompatActivity {
    EditText editTextWeight;
    EditText editTextValue;
    RadioGroup radioGroupType;
    RadioButton radioButtonKeep;
    Button buttonCalculate, btnReset;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("e-Zakat: Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextValue = findViewById(R.id.editTextValue);
        radioGroupType = findViewById(R.id.radioGroupType);
        radioButtonKeep = findViewById(R.id.radioButtonKeep);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);
        btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset input fields and result
                editTextWeight.getText().clear();
                editTextValue.getText().clear();
                radioGroupType.clearCheck();
                textViewResult.setText("");
            }
        });

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTextWeight.getText())) {
                    textViewResult.setTextColor(Color.RED); // Set text color to red
                    textViewResult.setText("Please enter weight.");
                    return;
                }

                if (TextUtils.isEmpty(editTextValue.getText())) {
                    textViewResult.setTextColor(Color.RED); // Set text color to red
                    textViewResult.setText("Please enter value.");
                    return;
                }

                if (radioGroupType.getCheckedRadioButtonId() == -1) {
                    textViewResult.setTextColor(Color.RED); // Set text color to red
                    textViewResult.setText("Please select a radio button.");
                    return;
                }

                double weight = Double.parseDouble(editTextWeight.getText().toString());
                double value = Double.parseDouble(editTextValue.getText().toString());

                String selectedRadioButtonText = ((RadioButton) findViewById(radioGroupType.getCheckedRadioButtonId())).getText().toString();

                double totalValue = (selectedRadioButtonText.equals("Keep") ? (weight - 85) : (weight - 200));

                double zakatPayable = (selectedRadioButtonText.equals("Keep") ? (weight - 85) : (weight - 200)) * value;

                double totalZakat = 0.025 * zakatPayable;

                textViewResult.setTextColor(Color.BLACK);

                textViewResult.setText(String.format(
                        "Total Value of Gold: RM%.2f\nZakat Payable: RM%.2f\nTotal Zakat: RM%.2f",
                        totalValue, zakatPayable, totalZakat));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the Up button press (back button)
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
