package com.snoott.android9;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();

        if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            View sidePanel = findViewById(R.id.side_fragment);

            if(sidePanel.getVisibility() == View.VISIBLE)
            {
                sidePanel.setVisibility(View.GONE);
            }
        }
    }
}
