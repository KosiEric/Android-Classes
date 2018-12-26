package com.snoott.android4;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {


    private TextView statusText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statusText = (TextView)findViewById(R.id.status_text);
        Switch switchButton = (Switch)findViewById(R.id.switch_button);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    statusText.setText(R.string.status_enabled);
                }
                else {
                    statusText.setText(R.string.status_disabled);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


     int itemId = item.getItemId();

     switch (itemId) {
         case R.id.action_exit :
             finish();
             break;
         case R.id.action_settings :
             AlertDialog.Builder alertDialogBuilder;

             alertDialogBuilder = (Build.VERSION.SDK_INT  > 20) ? new AlertDialog.Builder(MainActivity.this , android.R.style.Theme_Material_Dialog_Alert) : new AlertDialog.Builder(MainActivity.this);

             alertDialogBuilder.setTitle(R.string.Title_goes_here).setMessage(R.string.Message_goes_here).setNegativeButton(R.string.CANCEL, new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {

                     Toast.makeText(MainActivity.this , R.string.You_clicked_Cancel , Toast.LENGTH_SHORT).show();
                 }
             }).setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                     Toast.makeText(MainActivity.this , R.string.You_clicked_OK , Toast.LENGTH_LONG).show();
                 }
             }).create().show();
             break;

         case R.id.status :
             if(item.isChecked()){
                 statusText.setText(R.string.status_enabled);

             }

             else {

                 statusText.setText(R.string.status_disabled);
             }
             break;
             }



             return  super.onOptionsItemSelected(item);

         }
}