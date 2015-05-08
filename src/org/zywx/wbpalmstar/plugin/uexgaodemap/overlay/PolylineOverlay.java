package org.zywx.wbpalmstar.plugin.uexgaodemap.overlay;

import com.amap.api.maps.model.Polyline;

public class PolylineOverlay extends BaseOverlay{
    private Polyline polyline;

    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    @Override
    public void clearOverlay() {
        if (polyline != null){
            polyline.remove();
        }
    }
}
