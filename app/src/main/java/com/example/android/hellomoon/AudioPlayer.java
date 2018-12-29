package com.example.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    private MediaPlayer mPlayer;
    int pause=0;
    public void stop()
    {
        if(mPlayer!=null)
        {
            mPlayer.release();
            mPlayer=null;
        }
        pause=0;
    }
    public void play(Context c)
    {
        if(pause==1)
        {
            mPlayer.start();
        }
        else {
            stop();
            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });
            mPlayer.start();
        }
    }
    public void pause()
    {
        if(mPlayer!=null) {
            mPlayer.pause();
            pause = 1;
        }
        else
            stop();
    }
}
