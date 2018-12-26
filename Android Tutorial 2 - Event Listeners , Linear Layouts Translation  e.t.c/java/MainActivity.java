package com.snoott.android2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText username;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);





    }


    public void onYesButtonClick (View view){
        String username = this.username.getText().toString();
        StringBuilder stringBuilder = new StringBuilder("Nice to hear that " + username);
        Toast.makeText(this , stringBuilder , Toast.LENGTH_SHORT).show();

        stringBuilder = new StringBuilder();
    }

    public void onNoButtonClick(View view){
        String username = this.username.getText().toString();
        StringBuilder stringBuilder = new StringBuilder("Too bad " + username);
        Toast.makeText(this , stringBuilder , Toast.LENGTH_LONG).show();

        stringBuilder = new StringBuilder();

    }
}