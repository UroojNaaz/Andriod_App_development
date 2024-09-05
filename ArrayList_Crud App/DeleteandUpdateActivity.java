package com.example.arraylistcrudapp;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteandUpdateActivity extends AppCompatActivity {

    // Declare UI elements
    EditText edtupdate;
    Button btnupdate, btndelete;

    // List to store names and track the selected position
    ArrayList<String> Name;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteand_update);

        // Link UI elements to layout
        edtupdate = findViewById(R.id.edtupdate);
        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);

        // Get data passed from previous activity (list of names and selected position)
        Intent intent = getIntent();
        Name = intent.getStringArrayListExtra("std_data");
        position = intent.getIntExtra("position", -1);  // -1 if no position found

        // Set the selected name in the EditText for update
        if (Name != null && position != -1) {
            edtupdate.setText(Name.get(position));
        }

        // Update button click event
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Name != null && position != -1) {
                    // Update the name in the list
                    Name.set(position, edtupdate.getText().toString());

                    // Show a success message
                    Toast.makeText(DeleteandUpdateActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                    // Return the updated list back to the previous activity
                    Intent returnIntent = new Intent();
                    returnIntent.putStringArrayListExtra("updated_data", Name);
                    setResult(RESULT_OK, returnIntent);  // Send result back
                    finish();  // Close the activity
                }
            }
        });

        // Delete button click event
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Name != null && position != -1) {
                    // Remove the name from the list
                    Name.remove(position);

                    // Show a success message
                    Toast.makeText(DeleteandUpdateActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();

                    // Return the updated list back to the previous activity
                    Intent returnIntent = new Intent();
                    returnIntent.putStringArrayListExtra("updated_data", Name);
                    setResult(RESULT_OK, returnIntent);  // Send result back
                    finish();  // Close the activity
                }
            }
        });
    }
}
