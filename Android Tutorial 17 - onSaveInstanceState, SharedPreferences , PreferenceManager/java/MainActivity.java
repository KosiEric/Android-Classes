package  com.snoott.android18;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class  MainActivity extends AppCompatActivity
{

    EditText notesEditText;
    Button settingsButton;

    private static final String SAVED_NOTES_KEY = "NOTES";
    private  static  final  String EMPTY = "EMPTY";
    private static  final  Integer REQUEST_CODE = 1;
    Resources resources;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resources = getResources();
        notesEditText = (EditText)findViewById(R.id.notes_edit_text);
        settingsButton = (Button)findViewById(R.id.settings_button);


        String notes = savedInstanceState.getString(SAVED_NOTES_KEY , EMPTY);
        notes = notes.equals(EMPTY) ? getPreferences(MODE_PRIVATE).getString(SAVED_NOTES_KEY , EMPTY) : EMPTY;
        notesEditText.setText(notes.equals(EMPTY) ? EMPTY : notes);





        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent preferencesIntent = new Intent(MainActivity.this , SettingsActivity.class);
                startActivityForResult(preferencesIntent , REQUEST_CODE);
            }
        });
    }


    void saveSettings() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        notesEditText.setTypeface(null, sharedPreferences.getBoolean(resources.getString(R.string.preferences_bold_text), false) ? Typeface.BOLD : Typeface.NORMAL);
        String textSize = sharedPreferences.getString(resources.getString(R.string.preferences_text_size) , "16");
        Float textSizeFloat = Float.parseFloat(textSize);
        notesEditText.setTextSize(textSizeFloat);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            saveSettings();
        }
    }

    void saveNote ()
    {

        SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
        editor.putString(SAVED_NOTES_KEY , notesEditText.getText().toString());
        editor.apply();


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString(SAVED_NOTES_KEY , notesEditText.getText().toString());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onStop() {
        saveNote();
        super.onStop();

    }
}