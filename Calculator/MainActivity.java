package com.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtnum1,edtnum2;
        Button btnsum,btnsub,btndiv,btnmul,btnmode;
        TextView txtResult;
        LinearLayout main;
        main = findViewById(R.id.main);
        edtnum1 = findViewById(R.id.edtnum1);
        edtnum2 = findViewById(R.id.edtnum2);
        btnsum = findViewById(R.id.btnsum);
        btndiv = findViewById(R.id.btndiv);
        btnmode = findViewById(R.id.btnmode);
        btnmul = findViewById(R.id.btnmul);
        btnsub = findViewById(R.id.btnsub);
        txtResult = findViewById(R.id.txtResult);

        btnsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(edtnum1.getText().toString());
                int num2 = Integer.parseInt(edtnum2.getText().toString());
                int sum = num1 + num2;
                String desc = "Sum is : ";
                txtResult.setText(String.valueOf(desc)+String.valueOf(sum));
                main.setBackgroundColor(getResources().getColor(R.color.purple));
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}