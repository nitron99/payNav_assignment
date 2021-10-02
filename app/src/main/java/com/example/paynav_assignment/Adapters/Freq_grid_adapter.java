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

import static com.example.paynav_assignment.Activities.MainActivity.bottomSheetBehavior;

import com.example.paynav_assignment.Activities.MainActivity;
import com.example.paynav_assignment.Activities.UserDetailActivity;
import com.example.paynav_assignment.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class Freq_grid_adapter extends BaseAdapter {
    String[] names = new String[]{"Harshada","Naveen","Vivek","Rahul","Naveepriya"
            ,"Subhash" ,"Ramshankar"};

    public static int[] photos = new int[]{
            R.mipmap.a,R.mipmap.b, R.mipmap.c,R.mipmap.d, R.mipmap.e,R.mipmap.f, R.mipmap.g
    };

    Context context;

    public static boolean bottomsheet_state = true;

    public Freq_grid_adapter(Context context) {
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

        if(i == 4 && bottomsheet_state)
        {
            bottomsheet_state = false;
            textView.setText("RECENTS");
            textView.setTextColor(Color.WHITE);
            imageView.setImageResource(R.drawable.arrow_down_24);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            });

        }else{
            textView.setText(names[i]);
            imageView.setImageResource(photos[i]);
            textView.setTextColor(Color.WHITE);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, UserDetailActivity.class);
                    intent.putExtra("name", names[i]);
                    intent.putExtra("photo", photos[i]);
                    context.startActivity(intent);

                }
            });
        }


        return view;
    }
}
