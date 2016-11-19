package com.luoj.android.ffmpeg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FFmpegAPI fFmpegAPI=new FFmpegAPI();

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(fFmpegAPI.stringFromJNI());

        surfaceView= (SurfaceView) findViewById(R.id.surface_view);
    }

}
