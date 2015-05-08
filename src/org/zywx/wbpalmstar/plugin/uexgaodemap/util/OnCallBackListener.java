package org.zywx.wbpalmstar.plugin.uexgaodemap.util;

import com.amap.api.location.AMapLocation;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiResult;

import java.io.Serializable;

public interface OnCallBackListener extends Serializable{
    public void onMapLoaded();
    public void onMarkerClicked(String id);
    public void onBubbleClicked(String id);
    public void onReceiveLocation(AMapLocation location);
    public void onMapClick(LatLng point);
    public void onMapLongClick(LatLng point);
    public void cbGetCurrentLocation(AMapLocation location);
    public void cbGeocode(GeocodeResult geocodeResult, int errorCode);
    public void cbReverseGeocode(RegeocodeResult regeocodeResult, int errorCode);
    public void cbPoiSearch(PoiResult result, int errorCode);
    public void cbPoiSearchDetail(PoiItemDetail result, int errorCode);
}
