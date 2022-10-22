package com.example.activityresultlauncher;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activityresultlauncher.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;
    TextView tv;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySecondBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        String data=getIntent().getData().toString();
        tv.setText(data);

        btn.setOnClickListener(view -> {
           String s= tv.getText().toString();
            Intent intent=new Intent();
            intent.setData(Uri.parse(s));
            setResult(RESULT_OK,intent);
            finish();
        });
    }
}
class SecondActivityContract extends ActivityResultContract<String, String> {
    Context context;
    SecondActivityContract(Context context){
        this.context=context;
    }
    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, String s) {
        Intent intent=new Intent(context,SecondActivity.class);
        intent.setData(Uri.parse(s));
        return intent;
    }

    @Override
    public String parseResult(int code, @Nullable Intent result) {
        if (code!=Activity.RESULT_OK){
            Toast.makeText(context, "Data is null", Toast.LENGTH_SHORT).show();
            return null;
        }
        else {
            Toast.makeText(context, "Data received successfully", Toast.LENGTH_SHORT).show();
        }
        assert result != null;
        return result.getData().toString();
    }
    ///ajcbjkasbjkasjkasjkcjkashjkasjkasjk
    //asjkcklasl
}
