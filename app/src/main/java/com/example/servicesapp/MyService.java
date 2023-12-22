package com.example.servicesapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }
    MediaPlayer mp;
    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this,R.raw.Journey);
    }
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Service.onBind()", Toast.LENGTH_LONG).show();
        return null;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying()){
            mp.stop();
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flag, int startId){
        super.onStartCommand(intent,flag,startId);
        if (!mp.isPlaying()){
            mp.start();
        }
        return START_STICKY;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "Service.onUnbind()", Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }
}