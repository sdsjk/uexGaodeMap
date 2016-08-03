package org.zywx.wbpalmstar.plugin.uexgaodemap.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.amap.api.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.zywx.wbpalmstar.base.BUtility;
import org.zywx.wbpalmstar.engine.DataHelper;
import org.zywx.wbpalmstar.engine.EBrowserView;
import org.zywx.wbpalmstar.plugin.uexgaodemap.JsConst;
import org.zywx.wbpalmstar.plugin.uexgaodemap.VO.CustomBubbleVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.bean.MarkerBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GaodeUtils {

    public static List<MarkerBean> getAddMarkersData(EBrowserView ebrw, String json) {
        List<MarkerBean> list = new ArrayList<MarkerBean>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++){
                MarkerBean bean = getMarkerData(ebrw, jsonArray.getString(i));
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

    public static MarkerBean getMarkerData(EBrowserView ebrw, String json) {
        MarkerBean bean = new MarkerBean();
        try {
            JSONObject object = new JSONObject(json);
            String id = object.optString(JsConst.ID, String.valueOf(getRandomId()));
            bean.setId(id);
            if (object.has(JsConst.LONGITUDE) && object.has(JsConst.LATITUDE)){
                float longitude = Float.valueOf(object.getString(JsConst.LONGITUDE));
                float latitude = Float.valueOf(object.getString(JsConst.LATITUDE));
                bean.setPosition(new LatLng(latitude, longitude));
            }
            if (object.has(JsConst.ICON)){
                String icon = object.getString(JsConst.ICON);
                String path = BUtility.makeRealPath(
                        BUtility.makeUrl(ebrw.getCurrentUrl(), icon),
                        ebrw.getCurrentWidget().m_widgetPath,
                        ebrw.getCurrentWidget().m_wgtType);
                bean.setIcon(path);
            }
            if (object.has(JsConst.CUSTOM_BUBBLE)){
                String data = object.getString(JsConst.CUSTOM_BUBBLE);
                CustomBubbleVO dataVO = DataHelper.gson.fromJson(data, CustomBubbleVO.class);
                if (dataVO != null){
                    if (!TextUtils.isEmpty(dataVO.getData().getBgImg())){
                        String path = BUtility.makeRealPath(
                                BUtility.makeUrl(ebrw.getCurrentUrl(), dataVO.getData().getBgImg()),
                                ebrw.getCurrentWidget().m_widgetPath,
                                ebrw.getCurrentWidget().m_wgtType);
                        dataVO.getData().setBgImg(path);
                    }
                    bean.setCustomBubble(dataVO);
                }
            }else{
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
                        bean.setHasBubble(true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        bean.setHasBubble(false);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return bean;
    }

    public static MarkerBean getMarkerData(EBrowserView ebrw, String id, String json) {
        MarkerBean bean = new MarkerBean();
        try {
            JSONObject object = new JSONObject(json);
            bean.setId(id);
            if (object.has(JsConst.LONGITUDE) && object.has(JsConst.LATITUDE)){
                float longitude = Float.valueOf(object.getString(JsConst.LONGITUDE));
                float latitude = Float.valueOf(object.getString(JsConst.LATITUDE));
                bean.setPosition(new LatLng(latitude, longitude));
            }
            if (object.has(JsConst.ICON)){
                String icon = object.getString(JsConst.ICON);
                String path = BUtility.makeRealPath(
                        BUtility.makeUrl(ebrw.getCurrentUrl(), icon),
                        ebrw.getCurrentWidget().m_widgetPath,
                        ebrw.getCurrentWidget().m_wgtType);
                bean.setIcon(path);
            }
            if (object.has(JsConst.CUSTOM_BUBBLE)){
                String data = object.getString(JsConst.CUSTOM_BUBBLE);
                CustomBubbleVO dataVO = DataHelper.gson.fromJson(data, CustomBubbleVO.class);
                if (dataVO != null){
                    if (!TextUtils.isEmpty(dataVO.getData().getBgImg())){
                        String path = BUtility.makeRealPath(
                                BUtility.makeUrl(ebrw.getCurrentUrl(), dataVO.getData().getBgImg()),
                                ebrw.getCurrentWidget().m_widgetPath,
                                ebrw.getCurrentWidget().m_wgtType);
                        dataVO.getData().setBgImg(path);
                    }
                    bean.setCustomBubble(dataVO);
                }
            }else{
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
                        bean.setHasBubble(true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        bean.setHasBubble(false);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return bean;
    }


    public static String getCacheDir() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File fExternalStorageDirectory = Environment.getExternalStorageDirectory();
            File dir = new File(fExternalStorageDirectory,
                    "/widgetone/offlineMap/gaodemap");
            boolean result = false;
            if (!dir.exists()){
                result = dir.mkdirs();
            }else {
                result = true;
            }
            if (result) return dir.toString() + File.separator;
            else return null;
        } else {
            return null;
        }
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int getRandomId() {
        return (int)(Math.random() * 100000);
    }
}
