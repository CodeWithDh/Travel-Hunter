package com.women.womensaftey;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.core.VideoCapture;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;


public class Main_fragment extends Fragment {

    private static final int REQUESTCODE = 1;
    CardView sos, send_location, quick_call, police_station, quick_sms;
    LocationManager locationManager;
    double latitude;
    double longitude;
    String name, em_num,wp_num, alt_num;
    RelativeLayout videoCap;

    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    PreviewView previewView;
    @SuppressLint("RestrictedApi")
    private VideoCapture videoCapture;
    View view;
    public Main_fragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main_fragment, container, false);

        sos = view.findViewById(R.id.soss);
        send_location = view.findViewById(R.id.send_location);
        quick_call = view.findViewById(R.id.quick_call);
        police_station = view.findViewById(R.id.police_location);
        quick_sms = view.findViewById(R.id.sms);
        previewView = view.findViewById(R.id.previewView);
        videoCap = view.findViewById(R.id.videoCap);

        cameraProviderFuture = ProcessCameraProvider.getInstance(getActivity());
        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                startCameraX(cameraProvider);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, getExecutor());

        police_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode("police station"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });
        videoCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordVideo();
                Toast.makeText(getActivity(), "Recording Started....", Toast.LENGTH_SHORT).show();
            }
        });

        //Initilizing Location Manager
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


        }
       try {
           Location location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
           onLocationChanged(location);
             }catch (Exception e){
       }

        //Calling User data fetch method
        fetchUserData();

        send_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_location_WP();
            }
        });

        quick_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_sms();
            }
        });

        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomeDialog_Sos();
            }
        });

        quick_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quickCall_dialog();
            }
        });

        return view;
    }

    public void onLocationChanged(@NonNull Location location) {
        longitude = location.getLongitude();
        latitude = location.getLatitude();

    }

    public void fetchUserData(){
        Intent intent =getActivity().getIntent();
        name = intent.getStringExtra("name");
        wp_num = intent.getStringExtra("wp_num");
        em_num = intent.getStringExtra("em_num");
        alt_num = intent.getStringExtra("alt_num");

    }

    public void send_location_WP(){
        String whatsAppMessage =name+"\n I am in problem, Help me \n"+ "http://maps.google.com/?q=" + latitude + "," + longitude;
        //  String whatsAppMessage2 =name+"\n I am in problem, Help me \n"+ "http://maps.google.com/?q=" + latitude + "," + longitude;
        try {
            String mobile ="91"+wp_num;
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + mobile + "&text=" + whatsAppMessage)));
        }catch (Exception e){
            //whatsapp app not install
        }

    }

    public void send_sms (){

        String whatsAppMessage =name+"\n I am in problem, Help me \n"+ "http://maps.google.com/?q=" + latitude + "," + longitude;
        SmsManager smgr = SmsManager.getDefault();
        smgr.sendTextMessage(em_num,null,whatsAppMessage,null,null);
        Toast.makeText(getActivity(), "SMS Sent Successfully", Toast.LENGTH_SHORT).show();


        SmsManager smgrr = SmsManager.getDefault();
        smgrr.sendTextMessage(alt_num,null,whatsAppMessage,null,null);
        Toast.makeText(getActivity(), "SMS Sent Successfully", Toast.LENGTH_SHORT).show();

        SmsManager smgrrr = SmsManager.getDefault();
        smgrrr.sendTextMessage(wp_num,null,whatsAppMessage,null,null);
        Toast.makeText(getActivity(), "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
    }

    public void bottomeDialog_Sos(){
        BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
        dialog.setContentView(R.layout.sos_num_bottom);
        CardView dial_100 = dialog.findViewById(R.id.dial_100);
        CardView w_helpline = dialog.findViewById(R.id.w_helpline);
        CardView ambulance = dialog.findViewById(R.id.ambulance);
        String police = "100";
        String ambu = "108";
        String women_help = "1091";

        dial_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+police));
                startActivity(intent);
            }
        });

        w_helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+women_help));
                startActivity(intent);
            }
        });

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+ambu));
                startActivity(intent);
            }
        });

        dialog.show();
    }
    
    public void quickCall_dialog(){
            BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
        dialog.setContentView(R.layout.quick_call_popup);
        TextView firstNum = dialog.findViewById(R.id.first_num);
        TextView second_num = dialog.findViewById(R.id.second_num);
        TextView third_num = dialog.findViewById(R.id.third_num);
        firstNum.setText(em_num);

        firstNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+91" + em_num));
                startActivity(intent);
            }
        });

        second_num.setText(wp_num);

        second_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+91" + wp_num));
                startActivity(intent);
            }
        });

        third_num.setText(alt_num);

        third_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+91" + alt_num));
                startActivity(intent);
            }
        });

        dialog.show();
    }


    private Executor getExecutor() {
        return ContextCompat.getMainExecutor(getActivity());
    }

    @SuppressLint("RestrictedApi")
    private void startCameraX(ProcessCameraProvider cameraProvider) {

        cameraProvider.unbindAll();

        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();

        Preview preview = new Preview.Builder().build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        videoCapture = new VideoCapture.Builder()
                .setVideoFrameRate(30)
                .build();

        cameraProvider.bindToLifecycle(this, cameraSelector, preview, videoCapture);
    }
    @SuppressLint("RestrictedApi")
    private void recordVideo() {
        if (videoCapture != null) {
            long timeStamp = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, timeStamp);
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "video/mp4");


            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            videoCapture.startRecording(
                    new VideoCapture.OutputFileOptions.Builder(
                            getActivity().getContentResolver(),
                            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                            contentValues
                    ).build(),
                    getExecutor(),
                    new VideoCapture.OnVideoSavedCallback() {
                        @Override
                        public void onVideoSaved(@NonNull VideoCapture.OutputFileResults outputFileResults) {
                           try {
                               Toast.makeText(getActivity(), "Saving..." + outputFileResults.getSavedUri().toString(), Toast.LENGTH_SHORT).show();
                           }catch (NullPointerException e){

                           }
                        }

                        @Override
                        public void onError(int videoCaptureError, @NonNull String message, @Nullable Throwable cause) {
                            Toast.makeText(getActivity(), "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    }

            );


        }



    }


}
