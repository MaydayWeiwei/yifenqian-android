package com.yifenqian;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Main extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ImageView> imageViews = new ArrayList<ImageView>();
        imageViews.add((ImageView)findViewById(R.id.image1));
        imageViews.add((ImageView)findViewById(R.id.image2));
        imageViews.add((ImageView)findViewById(R.id.image3));
        imageViews.add((ImageView)findViewById(R.id.image4));
        imageViews.add((ImageView)findViewById(R.id.image5));
        new MainLoadTask("http://yifenqian.fr/app/api/v1/info/", imageViews).execute();
    }

//    @Override
//    public void onClick(View arg0) {
//        Button b = (Button)findViewById(R.id.my_button);
//        b.setClickable(false);
//        new LongRunningGetIO().execute();
//    }

}