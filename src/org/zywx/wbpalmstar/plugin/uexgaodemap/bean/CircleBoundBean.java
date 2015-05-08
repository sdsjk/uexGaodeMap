package org.zywx.wbpalmstar.plugin.uexgaodemap.bean;

import com.amap.api.services.core.LatLonPoint;

public class CircleBoundBean extends BoundBaseBean {
    private LatLonPoint center;
    private int radiusInMeters = 1000;
    private boolean isDistanceSort = true;

    public CircleBoundBean(String type) {
        super(type);
    }

    public LatLonPoint getCenter() {
        return center;
    }

    public void setCenter(LatLonPoint center) {
        this.center = center;
    }

    public int getRadiusInMeters() {
        return radiusInMeters;
    }

    public void setRadiusInMeters(int radiusInMeters) {
        this.radiusInMeters = radiusInMeters;
    }

    public boolean isDistanceSort() {
        return isDistanceSort;
    }

    public void setDistanceSort(boolean isDistanceSort) {
        this.isDistanceSort = isDistanceSort;
    }
}
