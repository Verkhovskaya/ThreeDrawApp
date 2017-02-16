package com.example.a2017_a.a3drawapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a2017_a.threedrawapp.R;

public class MainActivity extends AppCompatActivity {


    ImageView mImageView;
    CameraManager manager;
    String[] cameras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
    }



    public void go(View V){
        try {
            cameras = manager.getCameraIdList();
        }catch (Exception e){
            throw new android.hardware.camera2.CameraAccessException;
        }


    }
}
