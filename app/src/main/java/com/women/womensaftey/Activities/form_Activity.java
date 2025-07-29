package com.women.womensaftey.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.women.womensaftey.Home_Activity;
import com.women.womensaftey.R;

public class form_Activity extends AppCompatActivity {

    EditText name,em_number, alter_number, wp_number;
    RelativeLayout btn;
    SharedPreferences sharedPreferences;
    public static final String SP_NAME = "SP_NAME";
    public static final String NAME_KEY = "NAME";
    public static final String EM_NUMBER = "EM_NUMBER";
    public static final String ALT_NUMBER = "ALT_NAME";
    public static final String WP_NUM = "WP_NUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        name = findViewById(R.id.name);
        em_number = findViewById(R.id.Em_num);
        alter_number = findViewById(R.id.Al_number);
        wp_number = findViewById(R.id.Wp_number);
        btn = findViewById(R.id.save_btn);
        sharedPreferences = getSharedPreferences(SP_NAME, MODE_PRIVATE);
        permission();

        String full_name = sharedPreferences.getString(NAME_KEY, null);
        String wp_num = sharedPreferences.getString(WP_NUM, null);
        String em_num = sharedPreferences.getString(EM_NUMBER, null);
        String alt_num = sharedPreferences.getString(ALT_NUMBER, null);

        if (full_name !=null){
            Intent intent = new Intent(form_Activity.this, Home_Activity.class);
            intent.putExtra("name", full_name);
            intent.putExtra("wp_num", wp_num);
            intent.putExtra("em_num", em_num);
            intent.putExtra("alt_num", alt_num);
            startActivity(intent);
            finish();

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(NAME_KEY, name.getText().toString());
                editor.putString(EM_NUMBER, em_number.getText().toString());
                editor.putString(ALT_NUMBER, alter_number.getText().toString());
                editor.putString(WP_NUM, wp_number.getText().toString());
                editor.apply();

                Intent intent = new Intent(form_Activity.this, Home_Activity.class);
                intent.putExtra("name", full_name);
                intent.putExtra("wp_num", wp_num);
                intent.putExtra("em_num", em_num);
                intent.putExtra("alt_num", alt_num);

                startActivity(intent);

            }
        });


    }

    private void permission() {

        if (Build.VERSION.SDK_INT >= 16) {

            if (ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(form_Activity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.SEND_SMS,
                                Manifest.permission.CALL_PHONE,
                                Manifest.permission.CAMERA,
                                Manifest.permission.RECORD_AUDIO,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            } else {
                // Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();


            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //   Toast.makeText(this, "Permissions granted", Toast.LENGTH_SHORT).show();


            } else {
                ActivityCompat.requestPermissions(form_Activity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.SEND_SMS,
                                Manifest.permission.CALL_PHONE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
    }
}