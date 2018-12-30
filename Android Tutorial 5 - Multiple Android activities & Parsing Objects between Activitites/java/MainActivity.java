package com.snoott.android5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity {

    TextView theUsernameWas;
    private Button  goGetUsernameButton;
    public static final  String KEY= "callingActivity";
    public static final  Integer REQUEST_CODE = 12345;
    public static final  String HUMAN = "human";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theUsernameWas = (TextView)findViewById(R.id.the_username_was);
        goGetUsernameButton = (Button)findViewById(R.id.get_the_name_button);

        goGetUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getUsernameIntent = new Intent(MainActivity.this , SecondActivity.class);
                Bundle bundle;
                bundle = new Bundle();
                Human human = new Human("Bob" , 5.7 , 120);
                bundle.putSerializable(HUMAN , human);
                bundle.putString(KEY , this.getClass().getSimpleName());
                getUsernameIntent.putExtras(bundle);
                startActivityForResult(getUsernameIntent , REQUEST_CODE , bundle);

            }
        });






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            Bundle bundle = (Bundle)data.getExtras();
            String username = bundle.getString(SecondActivity.KEY);
            theUsernameWas.setText(username);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}