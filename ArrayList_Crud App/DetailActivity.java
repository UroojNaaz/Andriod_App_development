package com.example.arraylistcrudapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    // Declare button and ListView
    Button btnform;
    ListView std_listview;

    // ArrayList to hold student names
    ArrayList<String> Name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Link button and ListView to the layout
        btnform = findViewById(R.id.btnform);
        std_listview = findViewById(R.id.std_list);

        show_data();  // Display student data in ListView

        // Go back to form activity when "Form" button is clicked
        btnform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();  // Close the current activity
            }
        });

        // Handle item click in the ListView to open UpdateDeleteActivity
        std_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Create intent to open the update/delete activity
                Intent updateDeleteIntent = new Intent(DetailActivity.this, DeleteandUpdateActivity.class);
                updateDeleteIntent.putStringArrayListExtra("std_data", Name);
                updateDeleteIntent.putExtra("position", i);  // Send the position of clicked item
                startActivityForResult(updateDeleteIntent, 1);  // Open activity and expect result
            }
        });
    }

    // Method to show data in the ListView
    void show_data() {
        Intent std_intent = getIntent();  // Get data passed from previous activity
        Name = std_intent.getStringArrayListExtra("std_data");  // Retrieve list of names

        if (Name == null) {
            Name = new ArrayList<>();  // If no data, create an empty list
        }

        // Set adapter to display the names in ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Name);
        std_listview.setAdapter(adapter);
    }

    // Handle the result returned from UpdateDeleteActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Update the list with modified data
            Name = data.getStringArrayListExtra("updated_data");
            // Refresh ListView with new data
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Name);
            std_listview.setAdapter(adapter);
        }
    }
}
