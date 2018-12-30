package com.snoott.android5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    Button sendUsernameButton;
    TextView theUsernameWas;
    EditText username;
    TextView callingActivityTextView;
    static  Bundle bundle;
    public static String KEY = "username";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        sendUsernameButton = (Button)findViewById(R.id.send_name_button);
        username = (EditText)findViewById(R.id.username);
        theUsernameWas = (TextView)findViewById(R.id.the_username_was);
        callingActivityTextView = (TextView)findViewById(R.id.the_calling_activity_was);

                Intent intentReceived = getIntent();
                bundle = (Bundle)intentReceived.getExtras();
        Human human = (Human) bundle.getSerializable(MainActivity.HUMAN);
        Toast.makeText(this , human.toString() , Toast.LENGTH_LONG).show();

        String callingActivity = bundle.getString(MainActivity.KEY);
        callingActivityTextView.setText(callingActivity);


        sendUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendUsername = new Intent();
                bundle = new Bundle();
                bundle.putString(KEY , String.valueOf(username.getText()));
                setResult(RESULT_OK);
                finish();
            }
        });




    }
}

