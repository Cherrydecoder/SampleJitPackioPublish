package com.pratice.samplejitpackiopublish;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.pratice.myjitpacklibrary.ModuleTest;

public class MainActivity extends AppCompatActivity {

    TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello=findViewById(R.id.hello);
        hello.setOnClickListener(v->{

            Intent intent = new Intent(MainActivity.this, ModuleTest.class);
            startActivityForResult(intent, 100);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 100 && data != null) {
            String responseData = data.getStringExtra("response");
            Log.i("response",responseData);

        }
    }
}