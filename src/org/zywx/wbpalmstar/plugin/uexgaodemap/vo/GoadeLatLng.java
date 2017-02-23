package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;

public class GoadeLatLng implements Serializable{
    private static final long serialVersionUID = -2310064308171327627L;
    private double longitude;
    private double latitude;

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
