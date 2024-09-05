package com.example.listview_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Lists to store student names
    ArrayList<String> stu_name = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ListView student_name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Enable full screen
        setContentView(R.layout.activity_main);

        store_name();  // Fill stu_name with names
        student_name = findViewById(R.id.student_name);  // Get ListView

        // Add names at even positions to 'name'
        for (int i = 0; i <= stu_name.size(); i++) {
            if (i % 2 == 0) {
                name.add(stu_name.get(i));
            }
        }

        // Set up adapter for ListView
        ArrayAdapter<String> stu_Adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, name);
        student_name.setAdapter(stu_Adapter);

        // Show toast on item click
        student_name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "aoa " + name.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Add student names to stu_name
    void store_name() {
        stu_name.add("Noor");
        stu_name.add("Urooj");
        stu_name.add("Ali");
        stu_name.add("Abid");
        stu_name.add("Rizwan");
        stu_name.add("Samama");
        stu_name.add("Sabor");
    }
}
