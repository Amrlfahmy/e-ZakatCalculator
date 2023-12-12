package com.example.zakatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("e-Zakat");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnCal = findViewById(R.id.btnCal);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to start Calculator activity
                Intent intent = new Intent(MainActivity.this, calculator.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.item_Share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Please use my application - https://t.co/app");
            startActivity(Intent.createChooser(shareIntent, null));

            return true;
        }
        else if (item.getItemId() == R.id.item_About){
            Intent aboutIntent = new Intent(this,about.class);
            startActivity(aboutIntent);
        }
        else if (item.getItemId() == R.id.item_Calculator) {
            Intent calculatorIntent = new Intent(this, calculator.class);
            startActivity(calculatorIntent);

        }

        return false;
}
}
