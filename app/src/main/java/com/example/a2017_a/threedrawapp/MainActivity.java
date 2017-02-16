package com.example.a2017_a.threedrawapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a2017_a.threedrawapp.R;

public class MainActivity extends AppCompatActivity {


    CameraManager manager;
    String[] cameras;
    TextView textView;
    int increment = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        textView = (TextView) findViewById(R.id.textView);
    }



    public void go(View V){
        try {
            cameras = manager.getCameraIdList();
            CameraCharacteristics camera_characteristics = manager.getCameraCharacteristics("0");
            StreamConfigurationMap capture_options = camera_characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            Size[] sizes = capture_options.getOutputSizes(256); //format: JPEG
            textView.setText(sizes[increment].toString());
            increment += 1;
        } catch(CameraAccessException e) {
            throw new RuntimeException("Can't open camera manager");
        }



    }
}
