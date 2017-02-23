package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;

public class CustomButtonVO implements Serializable{
    private static final long serialVersionUID = -798511475809420228L;
    private String id;
    private String bgImage;
    private String title;
    private String titleColor;
    private double x;
    private double y;
    private double width;
    private double height;
    private int textSize = -1;

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public int getX() {
        return (int) x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getY() {
        return (int) y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWidth() {
        return (int) width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getHeight() {
        return (int) height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
