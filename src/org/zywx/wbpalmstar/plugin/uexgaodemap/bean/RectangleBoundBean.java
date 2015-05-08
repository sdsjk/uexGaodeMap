package org.zywx.wbpalmstar.plugin.uexgaodemap.bean;

import com.amap.api.services.core.LatLonPoint;

public class RectangleBoundBean extends BoundBaseBean {
    private LatLonPoint lowerLeft;
    private LatLonPoint upperRight;

    public RectangleBoundBean(String type) {
        super(type);
    }

    public LatLonPoint getLowerLeft() {
        return lowerLeft;
    }

    public void setLowerLeft(LatLonPoint lowerLeft) {
        this.lowerLeft = lowerLeft;
    }

    public LatLonPoint getUpperRight() {
        return upperRight;
    }

    public void setUpperRight(LatLonPoint upperRight) {
        this.upperRight = upperRight;
    }
}
