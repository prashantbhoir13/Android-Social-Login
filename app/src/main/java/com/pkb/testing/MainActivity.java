package com.pkb.testing;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pkb.cameralibrary.CameraGalleryImageActivity;

public class MainActivity extends AppCompatActivity {

    int ACTIVITY_REQUEST_CODE=1;
    int ACTIVITY_RESULT_CODE=2;
    //
    WindowManager windowManager;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image= (ImageView) findViewById(R.id.image);



    }

    public void add(View v){
        Intent in=new Intent(getApplicationContext(),CameraGalleryImageActivity.class);
        startActivityForResult(in,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.e("DATA RESPONCE Call",""+data.getExtras());
        if(requestCode==ACTIVITY_REQUEST_CODE){
            if(resultCode==ACTIVITY_RESULT_CODE){
                Log.e("DATA RESPONCE",""+data.getExtras().getString("path"));
                image.setImageURI(Uri.parse(data.getExtras().getString("path")));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
