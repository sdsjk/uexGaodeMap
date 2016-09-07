package org.zywx.wbpalmstar.plugin.uexgaodemap;

import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;

import org.zywx.wbpalmstar.plugin.uexgaodemap.util.OnCallBackListener;

public class GaodeMapLocationManager implements LocationSource{

    private LocationSource.OnLocationChangedListener mLocationChangedListener;
    private GaodeLocationListener mLocationListener;
    public OnCallBackListener mListener;
    private static final String TAG = "LocationMgr";

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {

    }

    @Override
    public void deactivate() {

    }

    private class GaodeLocationListener implements AMapLocationListener {
        int type = JsConst.INVALID;

        public int getType() {
            return type;
        }

        public void setType(int type){
            this.type = type;
        }


        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            Log.i(TAG, "onLocationChanged");
            if (aMapLocation != null && aMapLocation.getErrorCode() == 0){
                switch (type){
                    case JsConst.SHOW_LOCATION:
                    case JsConst.CONTINUED:
                        if (mLocationChangedListener != null) {
                            mLocationChangedListener.onLocationChanged(aMapLocation);// 显示系统小蓝点
                        }
                        if (mListener != null){
                            mListener.onReceiveLocation(aMapLocation);
                        }
                        break;
                    case JsConst.GET_LOCATION:
                        if (mListener != null){
                            mListener.cbGetCurrentLocation(aMapLocation);
                        }
                        break;
                }
            }
        }
    }
}
