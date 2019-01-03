package com.snoott.android10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends Activity {

    TextView superHeroNameTextView;
    TextView superHeroDescriptionTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_hero_description_layout);

        superHeroNameTextView = (TextView)findViewById(R.id.super_heroe_name);
        superHeroDescriptionTextView = (TextView)findViewById(R.id.super_heroe_description);

        superHeroDescriptionTextView.setMovementMethod(new ScrollingMovementMethod());


        Intent receiveSuperheroIntent = getIntent();
        Bundle bundle = new Bundle();
        bundle = receiveSuperheroIntent.getExtras();
        String name ,description  = null;
                try {

            name = bundle.getString(MainActivity.NAME);
            description = bundle.getString(MainActivity.DESCRIPTION);
            superHeroNameTextView.setText(name);
            superHeroDescriptionTextView.setText(description);
                }
        catch (NullPointerException exception)
        {
            String errorMessage = "Error at line " + exception.getStackTrace()[0].getLineNumber();

            Toast.makeText(DetailsActivity.this , errorMessage , Toast.LENGTH_LONG).show();
        }



    }
}
