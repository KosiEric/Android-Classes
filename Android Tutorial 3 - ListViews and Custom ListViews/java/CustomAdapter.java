package com.snoott.android3;


import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Profile>{

     CustomAdapter(Context context , ArrayList<Profile> resource) {
        super(context , R.layout.custom_layout , resource);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

         ViewHolder viewHolder;
         Profile profile = (Profile) getItem(position);
         if(convertView == null){
             viewHolder = new ViewHolder();
             convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_layout , parent , false);
             viewHolder.profileNameTextView = (TextView)convertView.findViewById(R.id.profile_name);
             viewHolder.profileDescriptionTextView = (TextView)convertView.findViewById(R.id.profile_description);
             viewHolder.profileImageView = (ImageView)convertView.findViewById(R.id.profile_image);
             convertView.setTag(viewHolder);
         }
         else {

             viewHolder = (ViewHolder)convertView.getTag();
             }
        viewHolder.profileNameTextView.setText(profile.getName());
        viewHolder.profileDescriptionTextView.setText(profile.getDescription());
        viewHolder.profileImageView.setImageResource(profile.getProfileImage());

        return convertView;
     }

    static class ViewHolder {
         public TextView profileNameTextView , profileDescriptionTextView;
         public ImageView profileImageView;
    }
}