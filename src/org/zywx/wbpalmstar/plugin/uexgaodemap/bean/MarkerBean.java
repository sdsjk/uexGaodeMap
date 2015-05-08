package org.zywx.wbpalmstar.plugin.uexgaodemap.bean;

import com.amap.api.maps.model.LatLng;

public class MarkerBean extends BaseBean{
    private String subTitle = null;
    private LatLng position = null;
    private String title = null;
    private String icon = null;
    private String bgImg = null;
    private boolean hasBubble;
    private float offsetX;
    private float offsetY;

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBgImg() {
        return bgImg;
    }

    public void setBgImg(String bgImg) {
        this.bgImg = bgImg;
    }

    public boolean isHasBubble() {
        return hasBubble;
    }

    public void setHasBubble(boolean hasBubble) {
        this.hasBubble = hasBubble;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }
}
