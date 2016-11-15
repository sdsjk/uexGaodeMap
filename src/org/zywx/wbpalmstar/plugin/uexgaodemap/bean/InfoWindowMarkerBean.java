package org.zywx.wbpalmstar.plugin.uexgaodemap.bean;

import com.amap.api.maps.model.LatLng;

/**
 * Created by fred on 16/11/15.
 */
public class InfoWindowMarkerBean extends BaseBean {
    private String subTitle = null;
    private LatLng position = null;
    private String title = null;
    private int titleSize;
    private int titleColor;
    private int subTitleSize;
    private int subTitleColor;

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

    public int getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(int titleSize) {
        this.titleSize = titleSize;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public int getSubTitleSize() {
        return subTitleSize;
    }

    public void setSubTitleSize(int subTitleSize) {
        this.subTitleSize = subTitleSize;
    }

    public int getSubTitleColor() {
        return subTitleColor;
    }

    public void setSubTitleColor(int subTitleColor) {
        this.subTitleColor = subTitleColor;
    }
}

