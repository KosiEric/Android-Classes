package com.snoott.android6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>
{

    private ArrayList<Profile> profiles;
    private Context context;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(this.context.getApplicationContext()).inflate(R.layout.row_layout , parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(view , i , this.context.getApplicationContext());
        return  myViewHolder;
    }

    public  MyRecyclerAdapter(Context context , ArrayList<Profile> profiles)
    {
        this.profiles = profiles;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

        Profile profile = (Profile)profiles.get(i);
        viewHolder.nameTextView.setText(profile.getName());
        viewHolder.descriptionTextView.setText(profile.getDescription());
        viewHolder.circleImageView.setImageResource(profile.getImage());
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView nameTextView , descriptionTextView;
        CircleImageView circleImageView;
        public MyViewHolder(View view , int position , final Context context)
        {
            super(view);

            nameTextView = view.findViewById(R.id.name_text_view);
            descriptionTextView = view.findViewById(R.id.description_text_view);

            circleImageView = view.findViewById(R.id.circle_image_view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context , "you clicked" , Toast.LENGTH_LONG).show();
                }
            });


        }

    }





}