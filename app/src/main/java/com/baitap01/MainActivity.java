package com.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText edtNumbers, edtString;
    Button btnProcessNumbers, btnProcessString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setContentView(R.layout.activity_main);
        // Ánh xạ view
        edtNumbers = findViewById(R.id.editTextText2);
        edtString = findViewById(R.id.editTextText3);
        btnProcessNumbers = findViewById(R.id.btnProcess);
        btnProcessString = findViewById(R.id.btnProcess2);

        // ===== Bài 4 ===== //
        btnProcessNumbers.setOnClickListener(v -> {
            String input = edtNumbers.getText().toString().trim();

            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập mảng số!", Toast.LENGTH_SHORT).show();
                return;
            }

            String[] parts = input.split("\\s+");
            ArrayList<Integer> numbers = new ArrayList<>();

            for (String p : parts) {
                try {
                    numbers.add(Integer.parseInt(p));
                } catch (NumberFormatException e) {
                    Log.d("Error", "Không hợp lệ: " + p);
                }
            }

            for (int num : numbers) {
                if (num % 2 == 0) {
                    Log.d("EvenNumber", "Số chẵn: " + num);
                } else {
                    Log.d("OddNumber", "Số lẻ: " + num);
                }
            }

            Toast.makeText(this, "Đã in ra Logcat số chẵn & lẻ!", Toast.LENGTH_SHORT).show();
        });

        // ===== Bài 5 ===== //
        btnProcessString.setOnClickListener(v -> {
            String text = edtString.getText().toString().trim();

            if (text.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập chuỗi ký tự!", Toast.LENGTH_SHORT).show();
                return;
            }
            String[] words = text.split("\\s+");
            ArrayList<String> reversed = new ArrayList<>();

            Collections.addAll(reversed, words);
            Collections.reverse(reversed);

            String reversedString = String.join(" ", reversed).toUpperCase();

            Toast.makeText(this, reversedString, Toast.LENGTH_LONG).show();
        });
    }
}