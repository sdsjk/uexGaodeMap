package org.zywx.wbpalmstar.plugin.uexgaodemap.util;

import com.amap.api.location.AMapLocation;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.poisearch.PoiResult;

import org.zywx.wbpalmstar.plugin.uexgaodemap.EUExGaodeMap;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.AvailableCityVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.AvailableProvinceVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.CustomButtonDisplayResultVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.CustomButtonResultVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.DownloadItemVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.DownloadResultVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.DownloadStatusVO;
import org.zywx.wbpalmstar.plugin.uexgaodemap.vo.UpdateResultVO;

import java.io.Serializable;
import java.util.List;

public interface OnCallBackListener extends Serializable{
    public void onMapLoaded();
    public void onMarkerClicked(String id);
    public void onBubbleClicked(String id);
    public void onReceiveLocation(AMapLocation location);
    public void onMapClick(LatLng point);
    public void onMapLongClick(LatLng point);
    public void cbGetCurrentLocation(AMapLocation location, int callbackId);
    public void cbGeocode(GeocodeResult geocodeResult, int errorCode, int callbackId);
    public void cbReverseGeocode(RegeocodeResult regeocodeResult, int errorCode, int callbackId);
    public void cbPoiSearch(PoiResult result, int errorCode, int callbackId);
    public void cbDownload(DownloadResultVO data, int callbackId, boolean isLast);
    public void onDownload(DownloadStatusVO data);
    public void cbDelete(DownloadResultVO data, int callbackId, boolean isLast);

    public void cbGetDownloadingList(List<DownloadItemVO> data, int callbackId);
    public void cbGetDownloadList(List<DownloadItemVO> data, int callbackId);
    public void cbGetAvailableCityList(List<AvailableCityVO> data, int callbackId);

    public void cbGetAvailableProvinceList(List<AvailableProvinceVO> data, int callbackId);

    public void cbIsUpdate(UpdateResultVO data, int callbackId);

    public void cbSetCustomButton(CustomButtonResultVO data);
    public void cbRemoveCustomButton(CustomButtonResultVO data);

    public void cbShowCustomButtons(CustomButtonDisplayResultVO data);
    public void cbHideCustomButtons(CustomButtonDisplayResultVO data);

    public void onButtonClick(String id, EUExGaodeMap gaodeMap);

}
