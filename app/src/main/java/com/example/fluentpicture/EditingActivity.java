package com.example.fluentpicture;

import static com.example.fluentpicture.MainActivity.imguri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.fluentpicture.databinding.ActivityEditingBinding;

public class EditingActivity extends AppCompatActivity {

    ActivityEditingBinding activityEditingBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEditingBinding = ActivityEditingBinding.inflate(getLayoutInflater());
        setContentView(activityEditingBinding.getRoot());

        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);
        dsPhotoEditorIntent.setData(imguri);

        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "My Album");

       // int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION, DsPhotoEditorActivity.TOOL_CROP};
      //  dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);
        startActivityForResult(dsPhotoEditorIntent, 200);


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            switch (requestCode) {

                case 200:

                    Uri outputUri = data.getData();

                    // handle the result uri as you want, such as display it in an imageView;

                    activityEditingBinding.imageView.setImageURI(outputUri);
                    Toast.makeText(EditingActivity.this,"Saved",Toast.LENGTH_LONG).show();
                    break;

            }

        }

    }
}