package org.zywx.wbpalmstar.plugin.uexgaodemap.VO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ylt on 2016/12/23.
 */
public class GaodeTransitVO implements Serializable {

    public float cost; //Number 预计总花费(元)
    public long duration; //Number 预计总耗时
    public boolean nightFlag; //Boolean 是否是夜班车
    public float walkingDistance; //Number 此方案的步行总距离(米)
    public float distance; //Number 此方案的总距离

    public List<GaodeSegmentVO> segments;

}
