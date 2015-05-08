package org.zywx.wbpalmstar.plugin.uexgaodemap.bean;

import com.amap.api.maps.model.GroundOverlayOptions;

public class GroundBean extends BaseBean{
    private GroundOverlayOptions data;

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public GroundOverlayOptions getData() {
        return data;
    }

    public void setData(GroundOverlayOptions data) {
        this.data = data;
    }
}
