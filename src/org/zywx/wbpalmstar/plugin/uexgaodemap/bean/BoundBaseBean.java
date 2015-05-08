package org.zywx.wbpalmstar.plugin.uexgaodemap.bean;

public class BoundBaseBean {
    private String type;
    public static final String TYPE_CIRCLE = "circle";
    public static final String TYPE_RECTANGLE = "rectangle";
    public static final String TYPE_POLYGON = "polygon";

    public BoundBaseBean(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
