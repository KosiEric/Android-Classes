package com.snoott.andorid0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String moviesArray[] = getResources().getStringArray(R.array.movies);
        movies = (ListView)findViewById(R.id.movies);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this , android.R.layout.simple_list_item_1 , moviesArray);
        movies.setAdapter(arrayAdapter);

        movies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String selectedMovie = String.valueOf(adapterView.getItemAtPosition(position));
                StringBuilder stringBuilder = new StringBuilder("You selected " + selectedMovie);
                Toast.makeText(MainActivity.this , stringBuilder , Toast.LENGTH_SHORT).show();
            }
        });

    }

}
