package com.snoott.android6;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Resources resources;
    ArrayList<Profile> profiles;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resources = getResources();

        String[] names = resources.getStringArray(R.array.names);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        Integer[] images = {R.drawable.mark , R.drawable.gate , R.drawable.tim ,
        R.drawable.musk , R.drawable.pichai , R.drawable.jobs , R.drawable.page,
        R.drawable.brin , R.drawable.jack , R.drawable.robin , R.drawable.allen , R.drawable.wozniak};

        profiles = new ArrayList<>();


        int count = 0;
        Profile profile;
        while (count < names.length)
        {
            profile = new Profile(names[count] , descriptions[count] , images[count]);
            profiles.add(profile);
            ++count;
        }

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager  = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this , profiles);

        recyclerView.setAdapter(myRecyclerAdapter);












    }
}
