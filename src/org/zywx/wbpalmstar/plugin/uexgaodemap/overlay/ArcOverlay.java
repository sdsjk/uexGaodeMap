package org.zywx.wbpalmstar.plugin.uexgaodemap.overlay;

import com.amap.api.maps.model.Arc;

public class ArcOverlay extends BaseOverlay {
    private Arc arc;

    public void setArc(Arc arc) {
        this.arc = arc;
    }

    @Override
    public void clearOverlay() {
        if (arc != null){
            arc.remove();
        }
    }
}
