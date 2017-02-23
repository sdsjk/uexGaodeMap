package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;

public class CustomButtonResultVO implements Serializable{
    private static final long serialVersionUID = 7741142133694264257L;
    private String id;
    private boolean isSuccess;

    public CustomButtonResultVO() {
    }

    public CustomButtonResultVO(String id, boolean isSuccess) {
        this.id = id;
        this.isSuccess = isSuccess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
