package com.example.testsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView numQuest, textQuest, progressTest;
    RadioGroup varAnswers;
    Resources resources;//для обращения к ресурсам
    String [] test;
    int countQuest = 1;
    public static final String MY_KEY_COLOR = "my color";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numQuest = findViewById(R.id.num_quest);
        textQuest = findViewById(R.id.text_quest);
        progressTest = findViewById(R.id.progress_test);
        varAnswers = findViewById(R.id.var_answers);

        resources = getResources();
        test = resources.getStringArray(R.array.test);

        //показываем номер вопроса
        String tmp = "Вопрос № " + countQuest;
        numQuest.setText(tmp);
        //показываем текст первого вопроса
        textQuest.setText(test[0]);
        //показываем варианты ответов
        for (int i = 0; i < varAnswers.getChildCount(); i++) {
            //RadioButton radioButton = (RadioButton) varAnswers.getChildAt(i);
            //radioButton.setText(test[i + 1]);
            if(test[i + 1].endsWith("+")) {
                tmp = test[i + 1].substring(0, test[i + 1].length() - 1);
                ((RadioButton) varAnswers.getChildAt(i)).setText(tmp);
            }else
                ((RadioButton) varAnswers.getChildAt(i)).setText(test[i + 1]);
        }
        tmp = countQuest + " / " + test.length / 5;
        progressTest.setText(tmp);
    }

    public void sendAnswer(View view) {
        //TODO проверить правильность ответа, посчитать статистику (потом)
        RadioButton radioButton = (RadioButton) varAnswers.getChildAt(0);
        radioButton.isChecked();
        countQuest++;
        if(countQuest <= test.length / 5) {
            //показываем номер вопроса
            String tmp = "Вопрос № " + countQuest;
            numQuest.setText(tmp);
            //показываем текст очередного вопроса
            int indexCurQuest = (countQuest - 1) * 5;
            textQuest.setText(test[indexCurQuest]);
            //показываем варианты ответов
            for (int i = 0; i < varAnswers.getChildCount(); i++) {
                //RadioButton radioButton = (RadioButton) varAnswers.getChildAt(i);
                //radioButton.setText(test[i + 1]);
                if (test[indexCurQuest + i + 1].endsWith("+")) {
                    tmp = test[indexCurQuest + i + 1]
                            .substring(0, test[indexCurQuest + i + 1].length() - 1);
                    ((RadioButton) varAnswers.getChildAt(i)).setText(tmp);
                } else
                    ((RadioButton) varAnswers.getChildAt(i))
                            .setText(test[indexCurQuest + i + 1]);
            }
            tmp = countQuest + " / " + test.length / 5;
            progressTest.setText(tmp);
        }else {
            //TODO показать результаты
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.about:
                Intent intent = new Intent(MainActivity.this,
                        AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.exit:
                //TODO что делать при выборе exit
        }
        return  true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        int color = getIntent().getIntExtra(MY_KEY_COLOR, 0);
        LinearLayout layout = findViewById(R.id.background_color);
        switch (color){
            case 1:
                layout.setBackgroundColor(Color.rgb(199, 216, 234));
                break;
            case 2:
                layout.setBackgroundColor(Color.parseColor("#A8CCAC"));
                break;
            case 3:
                layout.setBackgroundColor(Color.parseColor("#F3E0B2"));


        }

    }
}