package com.satyam.coustomdialogbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Custom_Dialog.CustomDialogInterface {
TextView textView1,textView2;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog custom_dialog=new Custom_Dialog();
                custom_dialog.show(getSupportFragmentManager(),"This is an example");
            }
        });
    }

    @Override
    public Void applyTexts(String textOne, String textTwo) {
        textView1.setText(textOne);
        textView2.setText(textTwo);
        return null;
    }
}