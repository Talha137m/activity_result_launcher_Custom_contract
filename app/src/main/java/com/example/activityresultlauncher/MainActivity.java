package com.example.activityresultlauncher;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activityresultlauncher.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Button btn;
    EditText etName,etPhone;
    TextView tv;
    ActivityResultLauncher<String> activityResultLauncher;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btn=findViewById(R.id.btn);
        etName=findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        tv=findViewById(R.id.tv);
        tv.setVisibility(View.GONE);
        activityResultLauncher=registerForActivityResult(new SecondActivityContract(MainActivity.this), new ActivityResultCallback<String>() {
            @Override
            public void onActivityResult(String result) {
                tv.setVisibility(View.VISIBLE);
                tv.setText(result);
            }
        });
        btn.setOnClickListener(view -> {
            String data=etName.getText().toString();
            String da=etPhone.getText().toString();
           String s= data+da;
           activityResultLauncher.launch(s);
        });
    }
}