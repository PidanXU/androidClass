package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_send = findViewById(R.id.send_button);
        bt_send.setOnClickListener(new MyClickListener(){

        });
    }
    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"this is just a button now!",Toast.LENGTH_LONG).show();
            return;
        }
    }
}