package  com.snoott.android10;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity
{
    ListView superHeroesListView;
    TextView superHeroeNameTextView;
    TextView superHeroeDescriptionTextView;
    String[] superHeroeNames;
    String[] superHeroeDescriptions;
    public final static  String NAME = "name";
    public final static String DESCRIPTION = "description";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superHeroeNameTextView = (TextView)findViewById(R.id.super_heroe_name);
        superHeroeDescriptionTextView = (TextView)findViewById(R.id.super_heroe_description);
        superHeroeDescriptionTextView.setMovementMethod(new ScrollingMovementMethod());



        Resources resources = getResources();

        superHeroeNames = resources.getStringArray(R.array.heroes);
        superHeroeDescriptions = resources.getStringArray(R.array.superheroe_descriptions);

        superHeroesListView = (ListView)findViewById(R.id.super_heroes);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this  , android.R.layout.simple_list_item_1 , superHeroeNames);
        superHeroesListView.setAdapter(arrayAdapter);


        Configuration configuration = resources.getConfiguration();

        final boolean isPortrait  =  configuration.orientation == Configuration.ORIENTATION_PORTRAIT;

        if(isPortrait)hideDetailsFragment();


        superHeroesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String superHeroName = superHeroeNames[position];
                String superHeroDescription = superHeroeDescriptions[position];

                if(!isPortrait){

                    superHeroeNameTextView.setText(superHeroName);
                    superHeroeDescriptionTextView.setText(superHeroDescription);
                }

                else {

                    Intent sendSuperheroIntent = new Intent(MainActivity.this , DetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(NAME , superHeroName);
                    bundle.putString(DESCRIPTION , superHeroDescription);
                    sendSuperheroIntent.putExtras(bundle);
                    startActivity(sendSuperheroIntent);

                }
            }
        });



    }

    void hideDetailsFragment () {
        View detailsFragment = findViewById(R.id.super_heroe_discription_fragment);
        if(detailsFragment.getVisibility() == View.VISIBLE){
            detailsFragment.setVisibility(View.GONE);
        }
    }
}