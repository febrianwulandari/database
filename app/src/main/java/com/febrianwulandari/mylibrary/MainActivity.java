package com.febrianwulandari.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnStore,btnGetAll;
    private DatabaseHelper databaseHelper;
    private EditText etname;
    private TextView tvnames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStore = findViewById(R.id.btnStore);
        btnGetAll = findViewById(R.id.btnget);
        etname = findViewById(R.id.etname);
        tvnames = findViewById(R.id.tvnames);
        databaseHelper = new DatabaseHelper(this);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tambahkan data
                databaseHelper.addStudentDetail(etname.getText().toString());
                etname.setText("");
                Toast.makeText(MainActivity.this,"Stored Successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Tampilkan Data
                arrayList = databaseHelper.getAllStudentsList();
                tvnames.setText("");
                for(String x:arrayList){
                    tvnames.setText(tvnames.getText().toString()+", "+x);

                }
            }
        }
        );
    }
}
