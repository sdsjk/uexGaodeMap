package org.zywx.wbpalmstar.plugin.uexgaodemap.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.webkit.URLUtil;

import com.amap.api.maps.model.LatLng;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.zywx.wbpalmstar.base.BUtility;
import org.zywx.wbpalmstar.plugin.uexgaodemap.JsConst;
import org.zywx.wbpalmstar.plugin.uexgaodemap.bean.MarkerBean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class GaodeUtils {
    public static Bitmap downloadImageFromNetwork(String url) {
        InputStream is = null;
        Bitmap bitmap = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            BasicHttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 30000);
            HttpConnectionParams.setSoTimeout(httpParams, 30000);
            HttpResponse httpResponse = new DefaultHttpClient(httpParams)
                    .execute(httpGet);
            int responseCode = httpResponse.getStatusLine().getStatusCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                is = httpResponse.getEntity().getContent();
                byte[] data = transStreamToBytes(is, 4096);
                if (data != null) {
                    bitmap = BitmapFactory
                            .decodeByteArray(data, 0, data.length);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    public static Bitmap getImage(Context ctx, String imgUrl) {
        if (imgUrl == null || imgUrl.length() == 0) {
            return null;
        }
        Bitmap bitmap = null;
        InputStream is = null;
        try {
            if (URLUtil.isNetworkUrl(imgUrl)) {
                bitmap = downloadImageFromNetwork(imgUrl);
            } else {
                if (imgUrl.startsWith(BUtility.F_Widget_RES_SCHEMA)) {
                    is = BUtility.getInputStreamByResPath(ctx, imgUrl);
                    bitmap = BitmapFactory.decodeStream(is);
                } else if (imgUrl.startsWith(BUtility.F_FILE_SCHEMA)) {
                    imgUrl = imgUrl.replace(BUtility.F_FILE_SCHEMA, "");
                    bitmap = BitmapFactory.decodeFile(imgUrl);
                } else if (imgUrl.startsWith(BUtility.F_Widget_RES_path)) {
                    try {
                        is = ctx.getAssets().open(imgUrl);
                        if (is != null) {
                            bitmap = BitmapFactory.decodeStream(is);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    bitmap = BitmapFactory.decodeFile(imgUrl);
                }
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    public static byte[] transStreamToBytes(InputStream is, int buffSize) {
        if (is == null) {
            return null;
        }
        if (buffSize <= 0) {
            throw new IllegalArgumentException(
                    "buffSize can not less than zero.....");
        }
        byte[] data = null;
        byte[] buffer = new byte[buffSize];
        int actualSize = 0;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            while ((actualSize = is.read(buffer)) != -1) {
                baos.write(buffer, 0, actualSize);
            }
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static List<MarkerBean> getAddMarkersData(String json) {
        List<MarkerBean> list = new ArrayList<MarkerBean>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++){
                MarkerBean bean = getMarkerData(jsonArray.getString(i));
                if (bean != null && bean.getPosition() != null){
                    list.add(bean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public static MarkerBean getMarkerData(String json) {
        MarkerBean bean = new MarkerBean();
        try {
            JSONObject object = new JSONObject(json);
            String id = object.getString(JsConst.ID);
            bean.setId(id);
            if (object.has(JsConst.LONGITUDE) && object.has(JsConst.LATITUDE)){
                float longitude = Float.valueOf(object.getString(JsConst.LONGITUDE));
                float latitude = Float.valueOf(object.getString(JsConst.LATITUDE));
                bean.setPosition(new LatLng(latitude, longitude));
            }
            if (object.has(JsConst.ICON)){
                String icon = object.getString(JsConst.ICON);
                bean.setIcon(icon);
            }
            if (object.has(JsConst.BUBBLE)){
                try {
                    JSONObject bubbleObject = object.getJSONObject(JsConst.BUBBLE);
                    String title = bubbleObject.getString(JsConst.TITLE);
                    bean.setTitle(title);
                    if (bubbleObject.has(JsConst.BGIMG)){
                        String bgImg = bubbleObject.getString(JsConst.BGIMG);
                        bean.setBgImg(bgImg);
                    }
                    if (bubbleObject.has(JsConst.SUBTITLE)){
                        String subTitle = bubbleObject.getString(JsConst.SUBTITLE);
                        bean.setSubTitle(subTitle);
                    }
                    if (bubbleObject.has(JsConst.OFFSETX)){
                        float offsetX = Float.valueOf(bubbleObject.getString(JsConst.OFFSETX));
                        bean.setOffsetX(offsetX);
                    }
                    if (bubbleObject.has(JsConst.OFFSETY)){
                        float offsetY = Float.valueOf(bubbleObject.getString(JsConst.OFFSETY));
                        bean.setOffsetY(offsetY);
                    }
                    bean.setHasBubble(true);
                } catch (JSONException e) {
                    e.printStackTrace();
                    bean.setHasBubble(false);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return bean;
    }

}
