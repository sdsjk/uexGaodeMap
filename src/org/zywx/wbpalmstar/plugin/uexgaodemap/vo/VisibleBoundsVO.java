package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;

public class VisibleBoundsVO implements Serializable{
    private static final long serialVersionUID = 5148979507462038572L;
    private double padding;

    public int getPadding() {
        return (int)padding;
    }

    public void setPadding(double padding) {
        this.padding = padding;
    }
}
