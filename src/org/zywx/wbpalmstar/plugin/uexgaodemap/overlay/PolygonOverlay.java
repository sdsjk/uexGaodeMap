package org.zywx.wbpalmstar.plugin.uexgaodemap.overlay;

import com.amap.api.maps.model.Polygon;

public class PolygonOverlay extends BaseOverlay {
    private Polygon polygon;

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public void clearOverlay() {
        if (polygon != null){
            polygon.remove();
        }
    }
}
