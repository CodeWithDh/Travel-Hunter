package com.women.womensaftey;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.women.womensaftey.Activities.Hotel_Street_Food;

import java.util.Locale;

public class Travel_Fragement extends Fragment implements AdapterView.OnItemSelectedListener {
    CardView best_library;
    CardView best_parks;
    AlertDialog.Builder builder;
    Context context;
    SharedPreferences.Editor editor;
    String getName;
    TextView language_name;
    Spinner language_spinner;
    SharedPreferences lastSelect;
    CardView leaser_destination;
    ImageView leaser_images;
    TextView location_name;
    RelativeLayout middle_bar;
    ImageView near_destination;
    CardView popular_dest;
    Spinner spinner;
    ImageView street_food;
    private Vibrator vibrator;


    public Travel_Fragement() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_travel__fragement, container, false);
            this.leaser_destination = (CardView) view.findViewById(R.id.leaser_destination);
            this.location_name = (TextView) view.findViewById(R.id.loction_name);
            this.leaser_images = (ImageView) view.findViewById(R.id.leaser_images);
            this.spinner = (Spinner) view.findViewById(R.id.spinner);

            this.language_spinner = (Spinner) view.findViewById(R.id.multi_language_spinner);
            this.language_name = (TextView) view.findViewById(R.id.multi_language);
            this.popular_dest = (CardView) view.findViewById(R.id.popular_dest);
            this.street_food = (ImageView) view.findViewById(R.id.near_street_food);
            this.best_parks = (CardView) view.findViewById(R.id.best_parks);
            this.best_library = (CardView) view.findViewById(R.id.best_library);
            ImageView imageView = (ImageView) view.findViewById(R.id.near_destination);
            this.near_destination = imageView;
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (getName.equals("Chandigarh")) {
                        Intent intent = new Intent(getContext(), Popular_Listing_Activies.class);
                        intent.putExtra("getData", "Chandigarh");
                        intent.putExtra("getData", "Chandigarh");
                        getContext().startActivity(intent);
                    }
                    if (getName.equals("Delhi")) {
                        Intent intent2 = new Intent(getContext(), Popular_Listing_Activies.class);
                        intent2.putExtra("getData", "Delhi");
                        getContext().startActivity(intent2);
                    }
                    if (getName.equals("Jaipur")) {
                        Intent intent3 = new Intent(getContext(), Popular_Listing_Activies.class);
                        intent3.putExtra("getData", "Jaipur");
                        getContext().startActivity(intent3);
                    }
                }
            });

            this.best_library.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (getName.equals("Chandigarh")) {
                        Intent intent = new Intent(getContext(), Library_Activities.class);
                        intent.putExtra("getData", "Chandigarh");
                        getContext().startActivity(intent);
                    }
                    if (getName.equals("Delhi")) {
                        Intent intent2 = new Intent(getContext(), Library_Activities.class);
                        intent2.putExtra("getData", "Delhi");
                        getContext().startActivity(intent2);
                    }
                    if (getName.equals("Jaipur")) {
                        Intent intent3 = new Intent(getContext(), Library_Activities.class);
                        intent3.putExtra("getData", "Jaipur");
                        getContext().startActivity(intent3);
                    }
                }
            });

            this.best_parks.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (Travel_Fragement.this.getName.equals("Chandigarh")) {
                        Intent intent = new Intent(context, Parks_Activity.class);
                        intent.putExtra("getData", "Chandigarh");
                        intent.putExtra("getData", "Chandigarh");
                      getContext().startActivity(intent);
                    }
                    if (Travel_Fragement.this.getName.equals("Delhi")) {
                        Intent intent2 = new Intent(context, Parks_Activity.class);
                        intent2.putExtra("getData", "Delhi");
                       getContext().startActivity(intent2);
                    }
                }
            });
            this.street_food.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                  startActivity(new Intent(getContext(), Hotel_Street_Food.class));
                }
            });

            this.middle_bar = (RelativeLayout) view.findViewById(R.id.middle_bar);
        ArrayAdapter<CharSequence> spinAdap = ArrayAdapter.createFromResource(requireContext(), R.array.city, android.R.layout.simple_spinner_item);
        spinAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(spinAdap);

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("LastSetting", Context.MODE_PRIVATE);
        this.lastSelect = sharedPreferences;
        this.editor = sharedPreferences.edit();
        int lastClck = this.lastSelect.getInt("LastClick", 0);
        this.spinner.setSelection(lastClck);
        this.spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> spinlan = ArrayAdapter.createFromResource(requireContext(), R.array.lan, android.R.layout.simple_spinner_item);
        spinlan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.language_spinner.setAdapter(spinlan);

        this.editor = this.lastSelect.edit();
        this.language_spinner.setSelection(lastClck);
        this.language_spinner.setOnItemSelectedListener(this);

        this.popular_dest.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (getName.equals("Chandigarh")) {
                        Intent intent = new Intent(getContext(), Popular_Listing_Activies.class);
                        intent.putExtra("getData", "Chandigarh");
                        intent.putExtra("getData", "Chandigarh");
                        getContext().startActivity(intent);
                    }

                    if (getName.equals("Jaipur")) {
                        @SuppressLint("RestrictedApi")
                        Intent intent2 = new Intent(getContext(), Popular_Listing_Activies.class);
                        intent2.putExtra("getData", "Jaipur");
                        getContext().startActivity(intent2);
                    }
                    if (getName.equals("Delhi")) {
                        Intent intent3 = new Intent(getContext(), Popular_Listing_Activies.class);
                        intent3.putExtra("getData", "Delhi");
                        getContext().startActivity(intent3);
                    }
                }
            });

            this.leaser_images.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
               //getContext().passdata();
                    passdata();
                }
            });
            return view;
        }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String userLocation = parent.getItemAtPosition(position).toString();
        this.editor.putInt("LastClick", position).commit();
        if (userLocation.equals("Chandigarh") || userLocation.equals("chandigarh")) {
            this.location_name.setText("Chandigarh");
            this.getName = "Chandigarh";
            this.middle_bar.setBackgroundResource(R.drawable.sukhan_lake_chandigarh);
        }
        if (userLocation.equals("Jaipur") || userLocation.equals("jaipur")) {
            this.location_name.setText("Jaipur");
            this.getName = "Jaipur";
            this.middle_bar.setBackgroundResource(R.drawable.jaipur);
        }
        if (userLocation.equals("Kharar") || userLocation.equals("kharar")) {
            this.location_name.setText("Khrar");
            this.getName = "Khrar";
            this.middle_bar.setBackgroundResource(R.drawable.khrar);
        }
        if (userLocation.equals("Delhi") || userLocation.equals("delhi")) {
            this.location_name.setText("Delhi");
            this.getName = "Delhi";
            this.middle_bar.setBackgroundResource(R.drawable.red_fort);
        }
        if (userLocation.equals("Seelampur - Delhi") || userLocation.equals("Shahdara - Seelampur") || userLocation.equals("Seelampur")) {
            this.location_name.setText("Seelampur - Delhi");
            this.getName = "Seelampur - Delhi";
            scamPop();
        }
        if (userLocation.equals("EN - IN") || userLocation.equals("hindi")) {
            this.language_name.setText("EN");
            setAppLanguage("EN");
        }
        if (userLocation.equals("Urdu") || userLocation.equals("urdu")) {
            this.language_name.setText("Urdu");
            setAppLanguage("ur");
        }
        if (userLocation.equals("Hindi") || userLocation.equals("HINDI")) {
            this.language_name.setText("Hindi");
            setAppLanguage("Hindi");
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void scamPop() {
        if (vibrator != null) {
            vibrator.vibrate(2000);
        }

        Context context = requireContext();
        if (context != null) {
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.spam_alert_dialog);

            Button spamButton = dialog.findViewById(R.id.spam_btn);
            if (spamButton != null) {
                spamButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }

            dialog.show();
        }
    }


    /* access modifiers changed from: package-private */
    public void passdata() {
        if (this.getName.equals("Chandigarh")) {
            @SuppressLint("RestrictedApi") Intent intent = new Intent(getContext(), leaser_known_Activity.class);
            intent.putExtra("getData", "Chandigarh");
            intent.putExtra("getData", "Chandigarh");
            startActivity(intent);
        }
        if (this.getName.equals("Delhi")) {
            @SuppressLint("RestrictedApi") Intent intent2 = new Intent(getContext(), leaser_known_Activity.class);
            intent2.putExtra("getData", "Delhi");
            startActivity(intent2);
        }
        if (this.getName.equals("Jaipur")) {
            @SuppressLint("RestrictedApi") Intent intent3 = new Intent(getContext(), leaser_known_Activity.class);
            intent3.putExtra("getData", "Jaipur");
             startActivity(intent3);
        }
    }

    private void setAppLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources =getContext().getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
