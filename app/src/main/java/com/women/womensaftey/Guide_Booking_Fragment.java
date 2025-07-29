package com.women.womensaftey;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Guide_Booking_Fragment extends Fragment {

    Button become_guide, looking_guide;

    public Guide_Booking_Fragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guide__booking_, container, false);
        become_guide = view.findViewById(R.id.become_guide);
        looking_guide = view.findViewById(R.id.looking_guide);

        looking_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Guide_Booking_Activity.class);
                startActivity(intent);
            }
        });

        become_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Become_Guide_Form.class);
                startActivity(intent);
            }
        });

        return view;
    }
}