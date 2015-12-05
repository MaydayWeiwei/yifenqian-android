package com.yifenqian;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei on 05/12/15.
 */
public class MainLoadTask extends AsyncTask<Void, Void, List<Bitmap>> {

    private String url;

    private List<ImageView> imageViews;

    public MainLoadTask (String url, List<ImageView> imageViews) {
        this.url = url;
        this.imageViews = imageViews;
    }

    @Override
    protected List<Bitmap> doInBackground(Void... params) {
        List<Bitmap> images = new ArrayList<>();
        try {
            URL urlConnection = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlConnection
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(input));
            String line = "";
            String result = "";
            while((line = bufferedReader.readLine()) != null)
                result += line;

            input.close();
            connection.disconnect();
            JSONObject jsonObject = new JSONObject(result);
            JSONArray infoList = jsonObject.getJSONArray("infoList");

            for (int i = 0; i < imageViews.size(); i++) {
                JSONObject jo = infoList.getJSONObject(i);
                images.add(ImageLoadHelper.loadImage(jo.get("coverImage").toString()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return images;
    }

    @Override
    protected void onPostExecute(List<Bitmap> bitmaps) {
        super.onPostExecute(bitmaps);
        try {
            for (int i = 0; i < bitmaps.size(); i++) {
                imageViews.get(i).setImageBitmap(bitmaps.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
