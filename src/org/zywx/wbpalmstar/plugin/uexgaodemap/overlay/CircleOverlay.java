package org.zywx.wbpalmstar.plugin.uexgaodemap.overlay;

import com.amap.api.maps.model.Circle;

public class CircleOverlay extends BaseOverlay {
    private Circle circle;

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void clearOverlay() {
        if (circle != null){
            circle.remove();
        }
    }
}
