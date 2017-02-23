package org.zywx.wbpalmstar.plugin.uexgaodemap.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
import android.text.TextUtils;

import com.amap.api.maps.model.LatLng;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.zywx.wbpalmstar.base.BUtility;
import org.zywx.wbpalmstar.engine.DataHelper;
import org.zywx.wbpalmstar.engine.EBrowserView;
import org.zywx.wbpalmstar.plugin.uexgaodemap.JsConst;
import org.zywx.wbpalmstar.plugin.uexgaodemap.bean.InfoWindowMarkerBean;
import org.zywx.wbpalmstar.plugin.uexgaodemap.bean.MarkerBean;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.CustomBubbleVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.GaodeBuslineVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.GaodeGeoPointVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.GaodePathVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.GaodeSegmentVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.GaodeStepVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.GaodeTransitVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.RouteSearchResultVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.SegmentWalkingVO;

import java.io.File;
import java.text.SimpleDateFormat;
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

    public static List<InfoWindowMarkerBean> getInfoWindowMarkersData(EBrowserView eBrowserView, String json) {
        List<InfoWindowMarkerBean> list = new ArrayList<InfoWindowMarkerBean>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++){
                InfoWindowMarkerBean bean = getInfoWindowMarker(eBrowserView, jsonArray.getString(i));
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

    public static InfoWindowMarkerBean getInfoWindowMarker(EBrowserView ebrw, String json) {
        InfoWindowMarkerBean bean = new InfoWindowMarkerBean();
        try {
            JSONObject object = new JSONObject(json);
            String id = object.getString(JsConst.ID);
            bean.setId(id);
            if (object.has(JsConst.LONGITUDE) && object.has(JsConst.LATITUDE)){
                float longitude = Float.valueOf(object.getString(JsConst.LONGITUDE));
                float latitude = Float.valueOf(object.getString(JsConst.LATITUDE));
                bean.setPosition(new LatLng(latitude, longitude));
            }

            String title = object.optString(JsConst.TITLE, null);
            String subTitle = object.optString(JsConst.SUBTITLE, null);
            int titleSize = object.optInt(JsConst.TITLE_SIZE, 32);
            titleSize = px2dip(ebrw.getContext(), titleSize);

            int subTitleSize = object.optInt(JsConst.SUBTITLE_SIZE, 28);
            subTitleSize = px2dip(ebrw.getContext(), subTitleSize);

            String titleColor = object.optString(JsConst.TITLE_COLOR, "#000000");
            String subTitleColor = object.optString(JsConst.SUBTITLE_COLOR, "#000000");
            bean.setTitle(title);
            bean.setSubTitle(subTitle);
            bean.setTitleSize(titleSize);
            bean.setSubTitleSize(subTitleSize);
            bean.setTitleColor(Color.parseColor(titleColor));
            bean.setSubTitleColor(Color.parseColor(subTitleColor));

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


    /*
    *
    *
    * 公交规划
    *
    * */

    public static RouteSearchResultVO getRouteSearchResultVO(BusRouteResult busRouteResult){
        RouteSearchResultVO resultVO=new RouteSearchResultVO();
        if (busRouteResult.getPaths()!=null){
            List<GaodeTransitVO> pathVOS=new ArrayList<GaodeTransitVO>();
            for (BusPath busPath:busRouteResult.getPaths()){
                pathVOS.add(getGaodePathVO(busPath));
            }
            resultVO.paths=pathVOS;
        }
        return resultVO;
    }

    private static GaodeTransitVO getGaodePathVO(BusPath busPath){
        GaodeTransitVO transitVO=new GaodeTransitVO();
        transitVO.cost=busPath.getCost();
        transitVO.distance=busPath.getDistance();
        transitVO.duration=busPath.getDuration();
        transitVO.nightFlag=busPath.isNightBus();
        transitVO.walkingDistance=busPath.getWalkDistance();
        if (busPath.getSteps()!=null){
            List<GaodeSegmentVO> stepVOS=new ArrayList<GaodeSegmentVO>();
            for (BusStep busStep:busPath.getSteps()){
                stepVOS.add(getGaodeSegmentVO(busStep));
            }
            transitVO.segments=stepVOS;
        }
        return transitVO;
    }

    private static GaodeSegmentVO getGaodeSegmentVO(BusStep busStep){
        GaodeSegmentVO segmentVO=new GaodeSegmentVO();
        if (busStep.getBusLines()!=null){
            List<GaodeBuslineVO> buslineVOS=new ArrayList<GaodeBuslineVO>();
            for (BusLineItem busLineItem:busStep.getBusLines()){
                buslineVOS.add(getGaodeBuslineVO(busLineItem));
            }
            segmentVO.buslines=buslineVOS;
        }
        if (busStep.getEntrance()!=null) {
            segmentVO.enterName = busStep.getEntrance().getName();
            segmentVO.enterPoint = getGaodeGeoPointVO(busStep.getEntrance().getLatLonPoint());
        }
        if (busStep.getExit()!=null) {
            segmentVO.exitName = busStep.getExit().getName();
            segmentVO.exitPoint=getGaodeGeoPointVO(busStep.getExit().getLatLonPoint());
        }
        if (busStep.getWalk()!=null) {
            segmentVO.walking = getSegmentWalkingVO(busStep.getWalk());
        }
        return segmentVO;
    }

    private static SegmentWalkingVO getSegmentWalkingVO(RouteBusWalkItem walkItem){
        SegmentWalkingVO walkingVO=new SegmentWalkingVO();
        if (walkItem.getOrigin()!=null) {
            walkingVO.origin = getGaodeGeoPointVO(walkItem.getOrigin());
        }
        if (walkItem.getDestination()!=null) {
            walkingVO.destination = getGaodeGeoPointVO(walkItem.getDestination());
        }
        walkingVO.distance=walkItem.getDistance();
        walkingVO.duration=walkItem.getDuration();
        if (walkItem.getSteps()!=null){
            List<GaodeStepVO> gaodeStepVOS=new ArrayList<GaodeStepVO>();
            for (WalkStep walkStep:walkItem.getSteps()){
                gaodeStepVOS.add(getGaodeStepVO(walkStep));
            }
            walkingVO.steps=gaodeStepVOS;
        }
        return walkingVO;
    }

    private static GaodeBuslineVO getGaodeBuslineVO(BusLineItem busLineItem){
        GaodeBuslineVO buslineVO=new GaodeBuslineVO();
        buslineVO.arrivalStop=busLineItem.getTerminalStation();
        buslineVO.departureStop=busLineItem.getOriginatingStation();
        buslineVO.distance=busLineItem.getDistance();
        buslineVO.duration=((RouteBusLineItem)busLineItem).getDuration();
        if (busLineItem.getFirstBusTime()!=null) {
            buslineVO.startTime =new SimpleDateFormat("HHmm").format(busLineItem.getFirstBusTime());//跟iOS 格式保持一致
        }
        if (busLineItem.getLastBusTime()!=null) {
            buslineVO.endTime = new SimpleDateFormat("HHmm").format(busLineItem.getLastBusTime());
        }
        buslineVO.name=busLineItem.getBusLineName();
        buslineVO.price=busLineItem.getTotalPrice();
        buslineVO.type=busLineItem.getBusLineType();
        buslineVO.uid=busLineItem.getBusLineId();
        buslineVO.viaStops=getViaStops(busLineItem.getBusStations());
        return buslineVO;
    }

    private static List<String> getViaStops(List<BusStationItem> busStationItems){
        if (busStationItems==null){
            return null;
        }
        List<String> viaStops=new ArrayList<String>();
        for (BusStationItem busStationItem:busStationItems){
            viaStops.add(busStationItem.getBusStationName());
        }
        return viaStops;
    }

    /*
    *
    * 步行规划
    *
    * */

    public static RouteSearchResultVO getRouteSearchResultVO(WalkRouteResult walkRouteResult){
        RouteSearchResultVO resultVO=new RouteSearchResultVO();
        if (walkRouteResult.getPaths()!=null){
            List<GaodePathVO> pathVOS=new ArrayList<GaodePathVO>();
            for (WalkPath walkPath:walkRouteResult.getPaths()){
                pathVOS.add(getGaodePathVO(walkPath));
            }
            resultVO.paths=pathVOS;
        }
        return resultVO;
    }

    private static GaodePathVO getGaodePathVO(WalkPath drivePath){
        GaodePathVO pathVO=new GaodePathVO();
        pathVO.distance=drivePath.getDistance();
        pathVO.duration=drivePath.getDuration();
        if (drivePath.getSteps()!=null){
            List<GaodeStepVO> stepVOS=new ArrayList<GaodeStepVO>();
            for (WalkStep driveStep:drivePath.getSteps()){
                stepVOS.add(getGaodeStepVO(driveStep));
            }
            pathVO.steps=stepVOS;
        }
        return pathVO;
    }

    private static GaodeStepVO getGaodeStepVO(WalkStep walkStep){
        GaodeStepVO stepVO=new GaodeStepVO();
        stepVO.action=walkStep.getAction();
        stepVO.distance=walkStep.getDistance();
        stepVO.duration=walkStep.getDuration();
        stepVO.instruction=walkStep.getInstruction();
        stepVO.orientation=walkStep.getOrientation();
        stepVO.road=walkStep.getRoad();
        if (walkStep.getPolyline()!=null){
            List<GaodeGeoPointVO> pointVOS=new ArrayList<GaodeGeoPointVO>();
            for (LatLonPoint point:walkStep.getPolyline()){
                pointVOS.add(getGaodeGeoPointVO(point));
            }
            stepVO.points=pointVOS;
        }
        return stepVO;
    }


    /*
    *
    * 开车规划
    * */

    public static RouteSearchResultVO getRouteSearchResultVO(DriveRouteResult driveRouteResult){
        RouteSearchResultVO resultVO=new RouteSearchResultVO();
        if (driveRouteResult.getPaths()!=null){
            List<GaodePathVO> pathVOS=new ArrayList<GaodePathVO>();
            for (DrivePath drivePath:driveRouteResult.getPaths()){
                pathVOS.add(getGaodePathVO(drivePath));
            }
            resultVO.paths=pathVOS;
        }
        resultVO.taxiCost=driveRouteResult.getTaxiCost();
        return resultVO;
    }

    private static GaodePathVO getGaodePathVO(DrivePath drivePath){
        GaodePathVO pathVO=new GaodePathVO();
        pathVO.distance=drivePath.getDistance();
        pathVO.duration=drivePath.getDuration();
        pathVO.strategy=drivePath.getStrategy();
        pathVO.tolls=drivePath.getTolls();
        if (drivePath.getSteps()!=null){
            List<GaodeStepVO> stepVOS=new ArrayList<GaodeStepVO>();
            for (DriveStep driveStep:drivePath.getSteps()){
                stepVOS.add(getGaodeStepVO(driveStep));
            }
            pathVO.steps=stepVOS;
        }
        return pathVO;
    }

    private static GaodeStepVO getGaodeStepVO(DriveStep driveStep){
        GaodeStepVO stepVO=new GaodeStepVO();
        stepVO.action=driveStep.getAction();
        stepVO.distance=driveStep.getDistance();
        stepVO.duration=driveStep.getDuration();
        stepVO.instruction=driveStep.getInstruction();
        stepVO.orientation=driveStep.getOrientation();
        stepVO.road=driveStep.getRoad();
        if (driveStep.getPolyline()!=null){
            List<GaodeGeoPointVO> pointVOS=new ArrayList<GaodeGeoPointVO>();
            for (LatLonPoint point:driveStep.getPolyline()){
                pointVOS.add(getGaodeGeoPointVO(point));
            }
            stepVO.points=pointVOS;
        }
        stepVO.tolls=driveStep.getTolls();
        return stepVO;
    }

    /*
     *
     * 骑车规划
     *
     */

    public static RouteSearchResultVO getRouteSearchResultVO(RideRouteResult walkRouteResult){
        RouteSearchResultVO resultVO=new RouteSearchResultVO();
        if (walkRouteResult.getPaths()!=null){
            List<GaodePathVO> pathVOS=new ArrayList<GaodePathVO>();
            for (RidePath ridePath:walkRouteResult.getPaths()){
                pathVOS.add(getGaodePathVO(ridePath));
            }
            resultVO.paths=pathVOS;
        }
        return resultVO;
    }

    private static GaodePathVO getGaodePathVO(RidePath ridePath){
        GaodePathVO pathVO=new GaodePathVO();
        pathVO.distance=ridePath.getDistance();
        pathVO.duration=ridePath.getDuration();
        if (ridePath.getSteps()!=null){
            List<GaodeStepVO> stepVOS=new ArrayList<GaodeStepVO>();
            for (RideStep driveStep:ridePath.getSteps()){
                stepVOS.add(getGaodeStepVO(driveStep));
            }
            pathVO.steps=stepVOS;
        }
        return pathVO;
    }

    private static GaodeStepVO getGaodeStepVO(RideStep walkStep){
        GaodeStepVO stepVO=new GaodeStepVO();
        stepVO.action=walkStep.getAction();
        stepVO.distance=walkStep.getDistance();
        stepVO.duration=walkStep.getDuration();
        stepVO.instruction=walkStep.getInstruction();
        stepVO.orientation=walkStep.getOrientation();
        stepVO.road=walkStep.getRoad();
        if (walkStep.getPolyline()!=null){
            List<GaodeGeoPointVO> pointVOS=new ArrayList<GaodeGeoPointVO>();
            for (LatLonPoint point:walkStep.getPolyline()){
                pointVOS.add(getGaodeGeoPointVO(point));
            }
            stepVO.points=pointVOS;
        }
        return stepVO;
    }


    private static GaodeGeoPointVO getGaodeGeoPointVO(LatLonPoint latLonPoint){
        if (latLonPoint==null){
            return null;
        }
        GaodeGeoPointVO pointVO=new GaodeGeoPointVO();
        pointVO.latitude=latLonPoint.getLatitude();
        pointVO.longitude=latLonPoint.getLongitude();
        return pointVO;
    }


}
