package com.luoj.android.ffmpeg;

import android.view.Surface;

/**
 * Created by 京 on 2016/11/14.
 */

public class FFmpegAPI {

    static {
        System.loadLibrary("ffmpeg-api");
    }

    public native String stringFromJNI();

    /**
     * 播放视频
     * @param surface
     * @param filePath
     * @return -1表示不能打开文件
     */
    public native int play(Surface surface,String filePath);

}
