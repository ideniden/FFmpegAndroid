package com.luoj.android.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by 京 on 2016/11/18.
 */

public class FFmpegPlayer extends SurfaceView implements SurfaceHolder.Callback {

    public FFmpegPlayer(Context context) {
        super(context);
    }

    public FFmpegPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FFmpegPlayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    FFmpegAPI fFmpegAPI;

    private SurfaceHolder mSurfaceHolder;

    String videoFilePath;

    void init(){
        mSurfaceHolder = getHolder();
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);//setType需放在addCallback前面，网上说的，不然有的手机崩溃
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setKeepScreenOn(true);
//        logu.d("init");
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(null!=fFmpegAPI&& !TextUtils.isEmpty(videoFilePath)){
            fFmpegAPI.play(mSurfaceHolder.getSurface(),videoFilePath);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void setFFmpegAPI(FFmpegAPI api){
        fFmpegAPI=api;
    }

    public void setVideoPath(String videoFilePath){
        this.videoFilePath=videoFilePath;
    }

}
