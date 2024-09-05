package com.example.arraylistcrudapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare buttons and input field
    Button btnapply, btndetail;
    EditText edtname;

    // ArrayList to store data
    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Enable edge-to-edge display
        setContentView(R.layout.activity_main);

        // Link buttons and input field to the layout
        btnapply = findViewById(R.id.btnapply);
        btndetail = findViewById(R.id.btndetails);
        edtname = findViewById(R.id.edtname);

        // Handle add button click
        btnapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add text from input field to ArrayList
                data.add(edtname.getText().toString());
                edtname.setText("");  // Clear input field
                // Show confirmation message
                Toast.makeText(MainActivity.this, "Successfully Added..!", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle details button click
        btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start new activity and pass data
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putStringArrayListExtra("std_data", data);
                startActivity(intent);  // Open DetailActivity
            }
        });
    }
}
