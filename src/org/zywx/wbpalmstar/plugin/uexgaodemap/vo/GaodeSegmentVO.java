package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ylt on 2016/12/23.
 */
public class GaodeSegmentVO implements Serializable {

    public SegmentWalkingVO walking;
    public List<GaodeBuslineVO> buslines;//Array<GaodeBusline> 可供选择的不同公交线路
    public String enterName;//String 入口名称
    public GaodeGeoPointVO enterPoint;//GaodePoint 入口坐标
    public String exitName; //String 出口名称
    public GaodeGeoPointVO exitPoint; //GaodePoint 出口坐标


}
