package com.example.paynav_assignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paynav_assignment.R;

public class UserDetailActivity extends AppCompatActivity {

    TextView user_name;
    ImageView user_image;
    ImageView toolbar_back_btn;

    Button transaction_btn;
    Button message_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int image = intent.getIntExtra("photo", 0);

        user_name = findViewById(R.id.user_name);
        user_image = findViewById(R.id.user_photo);
        toolbar_back_btn = findViewById(R.id.toolbar_back_btn);

        transaction_btn = findViewById(R.id.transaction_btn);
        message_btn = findViewById(R.id.message_btn);

        transaction_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TransactionActivity.class);
                startActivity(intent);

            }
        });
        message_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
                startActivity(intent);

            }
        });


        user_name.setText(name);
        user_image.setImageResource(image);

        toolbar_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}