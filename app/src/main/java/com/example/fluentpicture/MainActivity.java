package com.example.fluentpicture;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.fluentpicture.databinding.ActivityMainBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    public static Uri imguri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.addimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImagePicker.Companion.with(MainActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            imguri = data.getData();
            if (!imguri.equals("")){

                startActivity(new Intent(MainActivity.this,EditingActivity.class));
            }
        }catch (Exception e){

        }
    }
}