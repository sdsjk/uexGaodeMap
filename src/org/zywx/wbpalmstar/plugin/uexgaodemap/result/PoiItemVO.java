package org.zywx.wbpalmstar.plugin.uexgaodemap.result;

import com.amap.api.services.core.PoiItem;

import java.io.Serializable;

public class PoiItemVO implements Serializable {
    private static final long serialVersionUID = 3280351638137193305L;
    private String id;
    private String cityCode;
    private String cityName;
    private float distance;
    private String title;
    private String address;
    private String typeDes;
    private String tel;
    private String website;
    private String postcode;
    private String email;
    private String provinceName;
    private String provinceCode;
    private PointVO point;

    public PoiItemVO(PoiItem item) {
        setId(item.getPoiId());
        setCityCode(item.getCityCode());
        setCityName(item.getCityName());
        setDistance(item.getDistance());
        setTitle(item.getTitle());
        setAddress(item.getSnippet());
        setTypeDes(item.getTypeDes());
        setTel(item.getTel());
        setWebsite(item.getWebsite());
        setPostcode(item.getPostcode());
        setEmail(item.getEmail());
        setProvinceName(item.getProvinceName());
        setProvinceCode(item.getProvinceCode());
        setPoint(new PointVO(item.getLatLonPoint()));
    }

    public PointVO getPoint() {
        return point;
    }

    public void setPoint(PointVO point) {
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeDes() {
        return typeDes;
    }

    public void setTypeDes(String typeDes) {
        this.typeDes = typeDes;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
