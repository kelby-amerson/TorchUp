package com.example.kelby.torchup;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
//import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    //private Button buttonEnable;
    private Button sendButton;
    private ImageView imageFlashLight;
    private EditText textField;
    private static final int CAMERA_REQUEST = 50;
    private boolean flashLightStatus = false;
    private CharSequence sequence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = findViewById(R.id.sendButton);
        textField = findViewById(R.id.textField);


        final boolean hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        boolean isEnabled = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;

        //buttonEnable.setEnabled(!isEnabled);
        imageFlashLight.setEnabled(isEnabled);
        sendButton.setEnabled(!isEnabled);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, CAMERA_REQUEST);
            }
        });

        imageFlashLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasCameraFlash){
                    if(flashLightStatus)
                        flashLightOff();
                    else
                        flashLightOn();
                } else {
                    Toast.makeText(MainActivity.this, "No flash available on your device", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sequence = textField.getText();
                //String s = textField.getText().toString();
                for (int i = 0; i < textField.getText().length(); i++) {
                    if(flashLightStatus)
                        flashLightOff();
                    flashMorse(sequence.charAt(i));
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        });
    }

    private void flashMorse(char c){
        try {
            switch (c) {
                case 'a':
                    flashLightOn();
                    flashLightOff();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'b':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'c':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'd':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'e':
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'f':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'g':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'h':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'i':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'j':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'k':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'l':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'm':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'n':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'o':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'p':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 'q':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'r':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 's':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;
                case 't':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'u':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'v':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'w':
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'x':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'y':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    break;
                case 'z':
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    TimeUnit.SECONDS.sleep(1);
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    flashLightOn();
                    flashLightOff();
                    break;


            }
        }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    private void flashLightOn(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            flashLightStatus = true;
            imageFlashLight.setImageResource(R.drawable.btn_switch_on);
        }catch (CameraAccessException e){
            e.printStackTrace();
        }

    }

    private void flashLightOff(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            flashLightStatus = false;
            imageFlashLight.setImageResource(R.drawable.btn_switch_off);
        }catch (CameraAccessException e){
            e.printStackTrace();
        }

    }

/*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        switch(requestCode){
            case CAMERA_REQUEST:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    buttonEnable.setEnabled(false);
                    buttonEnable.setText("Camera Enabled");
                    imageFlashLight.setEnabled(true);
                } else {
                    Toast.makeText(MainActivity.this, "Permission Denied for the Camera", Toast.LENGTH_SHORT).show();
                }
        }
    }
*/
}
