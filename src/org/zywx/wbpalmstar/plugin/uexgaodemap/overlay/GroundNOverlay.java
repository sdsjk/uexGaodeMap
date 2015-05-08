package org.zywx.wbpalmstar.plugin.uexgaodemap.overlay;

import com.amap.api.maps.model.GroundOverlay;

public class GroundNOverlay extends BaseOverlay {
    private GroundOverlay groud;

    public void setGroud(GroundOverlay groud) {
        this.groud = groud;
    }

    @Override
    public void clearOverlay() {
        if (groud != null){
            groud.remove();
        }
    }
}
