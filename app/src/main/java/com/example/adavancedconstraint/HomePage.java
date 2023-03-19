package com.example.adavancedconstraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.google.android.material.badge.BadgeUtils;

import java.lang.reflect.Array;
import java.security.Permission;
import java.security.Permissions;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        Button cameraBtn = findViewById(R.id.openCamera);
        cameraBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                requestCameraPermission();
            }
        });

    }

    private void requestCameraPermission() {
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        } else {
            String[] permissions = {Manifest.permission.CAMERA};
            requestPermissions(permissions, 3);
        }
    }

    private void openCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
}