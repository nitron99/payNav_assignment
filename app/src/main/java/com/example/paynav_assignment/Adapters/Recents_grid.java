package com.example.paynav_assignment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paynav_assignment.Activities.UserDetailActivity;
import com.example.paynav_assignment.R;

public class Recents_grid extends BaseAdapter {

    String names[] = new String[]{
            "Sukshagar" ,"McDonalds","Harender","Harol","Halli","Red DP","Saksha"
            ,"Saksi","Sampreet","John","Suresh","Ramesh","Mukesh","Manish","Prakash"
            ,"Rakesh","Mukesh","Harender","Dev","Halli","Red DP","Saksha"
            ,"Saksi","Sampreet","John","Suresh","Ramesh","Mukesh","Manish","Prakash"
            ,"Rakesh","Mukesh","Harender", "Nitin"

    };


    int[] photos = new int[]{
            R.mipmap.h,R.mipmap.i, R.mipmap.j,R.mipmap.k, R.mipmap.l,R.mipmap.m, R.mipmap.n ,R.mipmap.o, R.mipmap.p
            ,R.mipmap.q, R.mipmap.s ,R.mipmap.t, R.mipmap.u ,R.mipmap.v, R.mipmap.w ,R.mipmap.x, R.mipmap.y ,R.mipmap.z, R.mipmap.aa
            ,R.mipmap.ab, R.mipmap.ac ,R.mipmap.ad, R.mipmap.ae ,R.mipmap.af, R.mipmap.ag ,R.mipmap.ah, R.mipmap.ai,R.mipmap.aj, R.mipmap.ak
            ,R.mipmap.al, R.mipmap.am ,R.mipmap.an, R.mipmap.ao ,R.mipmap.ap, R.mipmap.aq ,R.mipmap.ar
    };
    Context context;

    public Recents_grid(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.home_card, null );

        ImageView imageView = view.findViewById(R.id.home_card_image);
        TextView textView = view.findViewById(R.id.home_card_name);

        //imageView.setImageResource(R.drawable.ic_launcher_foreground);

        textView.setText(names[i]);
        textView.setTextColor(Color.WHITE);
        imageView.setImageResource(photos[i]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UserDetailActivity.class);
                intent.putExtra("name", names[i]);
                intent.putExtra("photo", photos[i]);
                context.startActivity(intent);

            }
        });



        return view;
    }
}
