package com.women.womensaftey.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.women.womensaftey.R;

public class Blog_read_Actiity extends AppCompatActivity {
    TextView detail;
    ImageView imageView;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blog_read_actiity);

      imageView = (ImageView) findViewById(R.id.detail_image_blog);
        title = (TextView) findViewById(R.id.detail_title);
        detail = (TextView) findViewById(R.id.discription_blog);
        Intent intent = getIntent();
        int image2 = intent.getExtras().getInt("image");
        String string = intent.getExtras().getString("city");
        String title2 = intent.getExtras().getString("title");
        String details2 = intent.getExtras().getString("details");
        imageView.setImageResource(image2);
        title.setText(title2);
        detail.setText(details2);

    }
}