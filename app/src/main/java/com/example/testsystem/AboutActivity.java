package com.example.testsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void sendColor(View view) {
        Button button = (Button) view;
        Intent intent = new Intent(AboutActivity.this, MainActivity.class);
        switch (button.getId()){
            case R.id.color1:
                intent.putExtra(MainActivity.MY_KEY_COLOR, 1);
                break;
            case R.id.color2:
                intent.putExtra(MainActivity.MY_KEY_COLOR, 2);
                break;
            case R.id.color3:
                intent.putExtra(MainActivity.MY_KEY_COLOR, 3);
        }
        startActivity(intent);
    }

    //TODO добавить меню опций
}