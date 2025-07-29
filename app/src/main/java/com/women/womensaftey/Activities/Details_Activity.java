package com.women.womensaftey.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.women.womensaftey.Guide_Booking_Activity;
import com.women.womensaftey.R;

public class Details_Activity extends AppCompatActivity {

    Button btn_location,find_guide;
    TextView detail_discription;
    ImageView detail_iamge;
    TextView detail_text;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        this.detail_iamge = (ImageView) findViewById(R.id.detail_image);
        this.detail_text = (TextView) findViewById(R.id.detail_name);
        this.detail_discription = (TextView) findViewById(R.id.discription);
        this.btn_location = (Button) findViewById(R.id.location);
        find_guide = (Button) findViewById(R.id.find_guide);
        Intent intent = getIntent();
        int image2 = intent.getExtras().getInt("image");
        String name2 = intent.getExtras().getString("name");
        final String adress = intent.getExtras().getString("address");
        String string = intent.getExtras().getString("budget");
        String disc = intent.getExtras().getString("disc");
        this.detail_iamge.setImageResource(image2);
        this.detail_text.setText(name2);
        this.detail_discription.setText(disc);
        this.btn_location.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mapIntent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + Uri.encode(adress)));
                mapIntent.setPackage("com.google.android.apps.maps");
                Details_Activity.this.startActivity(mapIntent);
            }
        });

        find_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Guide_Booking_Fragment guideBookingFragment = new Guide_Booking_Fragment();
//
//                // Replacing the fragment container with the new instance of Guide_Booking_Fragment
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.flFragment, guideBookingFragment)
//                        .commit();

                Intent intent1 = new Intent(Details_Activity.this, Guide_Booking_Activity.class);
                startActivity(intent1);

            }
        });
    }
}