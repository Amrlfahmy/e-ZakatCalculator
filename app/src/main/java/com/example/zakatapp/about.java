package com.example.zakatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("e-Zakat: About us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find the "Edit Profile" button
        Button editProfileButton = findViewById(R.id.profile_edit_button);

        // Set OnClickListener to handle button click
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the link when the button is clicked
                openLink("https://github.com/Amrlfahmy");
            }
        });
    }

    private void openLink(String url) {
        // Create an Intent to open a web page
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the Up button press (back button)
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish(); // Optional: Finish the current activity to prevent it from stacking on the back stack
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
