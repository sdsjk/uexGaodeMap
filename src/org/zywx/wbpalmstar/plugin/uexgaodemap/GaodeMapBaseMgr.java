package org.zywx.wbpalmstar.plugin.uexgaodemap;

import android.content.Context;

import com.amap.api.maps.AMap;

import org.zywx.wbpalmstar.plugin.uexgaodemap.util.OnCallBackListener;

public class GaodeMapBaseMgr {
    protected Context mContext;
    protected AMap map;
    protected OnCallBackListener mListener;

    public GaodeMapBaseMgr(Context mContext, AMap map, OnCallBackListener mListener) {
        this.mContext = mContext;
        this.map = map;
        this.mListener = mListener;
    }
}
