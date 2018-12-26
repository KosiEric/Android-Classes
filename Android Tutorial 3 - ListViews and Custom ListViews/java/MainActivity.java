package com.snoott.android3;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView techPeopleListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        final String profileNames[] = resources.getStringArray(R.array.profileNames);
        String profileDescriptions[] = resources.getStringArray(R.array.profileDescriptions);
        Integer[] profileImages = {
                R.drawable.dustin,
                R.drawable.elon,
                R.drawable.gate,
                R.drawable.mark,
                R.drawable.page,
                R.drawable.sergey,
                R.drawable.steve,
                R.drawable.tim
        };

        techPeopleListView = (ListView)findViewById(R.id.techPeopleListView);

        ArrayList<Profile> profiles = new ArrayList<Profile>();
        int k =0;
        while (k < profileNames.length){

            profiles.add(new Profile(profileNames[k] , profileDescriptions[k] , profileImages[k]));
            ++k;
        }

        ArrayAdapter<Profile> profileArrayAdapter = new CustomAdapter(MainActivity.this , profiles);
        techPeopleListView.setAdapter(profileArrayAdapter);

        techPeopleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Profile profile = (Profile)adapterView.getItemAtPosition(position);
                String profileName = profile.getName();
                String profileDescription = profile.getDescription();
                String message = String.format("%s\n%s" , profileName , profileDescription);
                Toast.makeText(MainActivity.this , message , Toast.LENGTH_LONG).show();
            }
        });

    }
}