package com.example.app_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText ed;
    Button submit;
    ProgressBar progressBar;

    @Override
    protected void onStart() {
        super.onStart();

        CountDownTimer countDownTimer=new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int current=progressBar.getProgress() + 10;
                if (current > progressBar.getMax()) current=0;
                progressBar.setProgress(current);
            }

            @Override
            public void onFinish() {

                ed.setInputType(0);
                ed.setInputType(InputType.TYPE_NULL);

                View view=MainActivity3.this.getCurrentFocus();

                if (view!=null){
                    InputMethodManager methodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    methodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
                }

                submit.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity3.this, "Finish", Toast.LENGTH_SHORT).show();
            }
        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ed=findViewById(R.id.ed1);

        submit=findViewById(R.id.submit);

        progressBar=findViewById(R.id.progressBar2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer=ed.getText().toString();

                Intent intent=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }

}