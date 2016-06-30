package org.zywx.wbpalmstar.plugin.uexgaodemap.result;


import java.io.Serializable;

public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 1190316894677877554L;

    private String type;

    private T data;

    private int errorCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
