package com.example.paynav_assignment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.paynav_assignment.Activities.UserDetailActivity;
import com.example.paynav_assignment.Classes.User;
import com.example.paynav_assignment.R;

public class FriendlistAdapter extends ArrayAdapter<User> {


    Context context;
    int mResource;

    String[] names = new String[]{
            "Ananya Rao","Rajashi Prakash"
            ,"Harshada Nikam","John Born"
    };


    int[] dues= new int[]{3332,800,250,50};

    int[] photos = new int[]{
            R.mipmap.a,R.mipmap.b, R.mipmap.c,R.mipmap.d
    };


    public FriendlistAdapter(@NonNull Context context, int resource, String[] names) {
        super(context, resource);
        this.mResource = resource;
        this.names = names;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(mResource,null);


        ImageView photo = convertView.findViewById(R.id.friend_image);
        TextView name = convertView.findViewById(R.id.friend_name);
        TextView due = convertView.findViewById(R.id.friend_due_money);


        photo.setImageResource(photos[position]);
        name.setText(names[position]);
        due.setText(dues[position]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UserDetailActivity.class);
                intent.putExtra("name", names[position]);
                intent.putExtra("photo", photos[position]);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
