package com.snoott.android1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button firstButton;
    TextView firstTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstButton = (Button)findViewById(R.id.firstButton);
        firstTextView = (TextView)findViewById(R.id.firstTextView);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firstTextView.setText(R.string.you_clicked);
            }
        });
    }
}