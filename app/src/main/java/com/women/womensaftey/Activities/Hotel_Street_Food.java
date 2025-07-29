package com.women.womensaftey.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.women.womensaftey.Hotel_Street_Adapter;
import com.women.womensaftey.Model.Hotel_Street_Model;
import com.women.womensaftey.R;

import java.util.ArrayList;

public class Hotel_Street_Food extends AppCompatActivity {

    ArrayList<Hotel_Street_Model> arrayList = new ArrayList<>();
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hotel_street_food);

         RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recylerView2);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        this.arrayList.add(new Hotel_Street_Model(R.drawable.brother, "Brothers Chola Kulcha", "Sector 9, Chandigarh", "Mob - 088474 84215", "9:30 AM - 8 PM"));
        this.arrayList.add(new Hotel_Street_Model(R.drawable.brother, "Chinese food Market ", "Chapri Choraha", "Not-Available", "9 AM - 11 PM"));
        this.arrayList.add(new Hotel_Street_Model(R.drawable.bombay, "Bombay PavBhaji ", "Zirakpur HO, Zirakpur", "+91 98727 22801 ", "3:00 pm - 11:30 pm"));
        this.recyclerView.setAdapter(new Hotel_Street_Adapter(this, this.arrayList));

    }
}