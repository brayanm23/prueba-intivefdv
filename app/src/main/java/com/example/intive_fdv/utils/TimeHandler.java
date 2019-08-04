package com.example.intive_fdv.utils;

import android.os.Handler;

/**
 * Created by Harold Montenegro on 20/9/2016.
 */

public class TimeHandler extends Handler {
    private Integer time;
    private OnTimeComplete onTimeComplete;
    private Runnable runnable;

    public TimeHandler(Integer time, OnTimeComplete onTimeComplete) {
        this.time = time;
        this.onTimeComplete = onTimeComplete;
    }

    public void start() {
        runnable = new Runnable() {
            @Override
            public void run() {
                onTimeComplete.onFinishTime();
                runnable = null;
            }
        };
        postDelayed(runnable, time);
    }

    public void stop() {
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable = null;
        }
    }

    public interface OnTimeComplete {
        public void onFinishTime();
    }

}
