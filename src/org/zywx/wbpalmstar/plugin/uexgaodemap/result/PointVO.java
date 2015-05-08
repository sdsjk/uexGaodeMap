package org.zywx.wbpalmstar.plugin.uexgaodemap.result;

import com.amap.api.services.core.LatLonPoint;

import java.io.Serializable;

public class PointVO implements Serializable{

    private static final long serialVersionUID = -7712270091719746343L;
    private double longitude;
    private double latitude;

    public PointVO(LatLonPoint point) {
        setLongitude(point.getLongitude());
        setLatitude(point.getLatitude());
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
