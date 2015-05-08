package org.zywx.wbpalmstar.plugin.uexgaodemap.result;

import com.amap.api.services.poisearch.Discount;
import com.amap.api.services.poisearch.Groupbuy;

import java.io.Serializable;
import java.util.List;

public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 1190316894677877554L;

    private String type;

    private T data;

    private List<Discount> discount;

    private List<Groupbuy> groupbuy;

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

    public List<Discount> getDiscount() {
        return discount;
    }

    public void setDiscount(List<Discount> discount) {
        this.discount = discount;
    }

    public List<Groupbuy> getGroupbuy() {
        return groupbuy;
    }

    public void setGroupbuy(List<Groupbuy> groupbuy) {
        this.groupbuy = groupbuy;
    }
}
