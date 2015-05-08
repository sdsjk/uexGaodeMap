package org.zywx.wbpalmstar.plugin.uexgaodemap.bean;

import com.amap.api.services.core.LatLonPoint;

import java.util.List;

public class PolygonBoundBean extends BoundBaseBean {
    private List<LatLonPoint> list;

    public PolygonBoundBean(String type) {
        super(type);
    }

    public List<LatLonPoint> getList() {
        return list;
    }

    public void setList(List<LatLonPoint> list) {
        this.list = list;
    }
}
