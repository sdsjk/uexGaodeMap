package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;

/**
 * Created by ylt on 2016/12/24.
 */
public class TransitRouteSearchVO implements Serializable {

    public GaodeGeoPointVO origin; //GaodePoint 起始地
    public GaodeGeoPointVO destination;//GaodePoint 目的地

    public String city;//String 当前城市
    public boolean nightFlag;//Boolean 是否包含夜班车  默认false
    public int strategy; // Number 公交换乘策略,默认0  0-最快捷模式；1-最经济模式；2-最少换乘模式；3-最少步行模式；4-最舒适模式；5-不乘地铁模式


}
