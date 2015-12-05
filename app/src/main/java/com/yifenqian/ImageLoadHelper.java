package com.yifenqian;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wei on 05/12/15.
 */

public class ImageLoadHelper {

    public static Bitmap loadImage (String addressUrl) throws IOException {

        URL url = new URL(addressUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        InputStream is = conn.getInputStream();
        return BitmapFactory.decodeStream(is);
    }

}
