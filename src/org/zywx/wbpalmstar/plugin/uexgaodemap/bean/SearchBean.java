package org.zywx.wbpalmstar.plugin.uexgaodemap.bean;

public class SearchBean {
    private String city;
    private String searchKey = "";
    private int pageNumber;
    private int pageSize;
    private String poiTypeSet = "";
    private String language;
    private BoundBaseBean searchBound;
    private boolean isShowMarker = false;
    private boolean isShowDiscount = false;
    private boolean isShowGroupbuy = false;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPoiTypeSet() {
        return poiTypeSet;
    }

    public void setPoiTypeSet(String poiTypeSet) {
        this.poiTypeSet = poiTypeSet;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BoundBaseBean getSearchBound() {
        return searchBound;
    }

    public void setSearchBound(BoundBaseBean searchBound) {
        this.searchBound = searchBound;
    }

    public boolean isShowMarker() {
        return isShowMarker;
    }

    public void setShowMarker(boolean isShowMarker) {
        this.isShowMarker = isShowMarker;
    }

    public boolean isShowDiscount() {
        return isShowDiscount;
    }

    public void setShowDiscount(boolean isShowDiscount) {
        this.isShowDiscount = isShowDiscount;
    }

    public boolean isShowGroupbuy() {
        return isShowGroupbuy;
    }

    public void setShowGroupbuy(boolean isShowGroupbuy) {
        this.isShowGroupbuy = isShowGroupbuy;
    }
}
