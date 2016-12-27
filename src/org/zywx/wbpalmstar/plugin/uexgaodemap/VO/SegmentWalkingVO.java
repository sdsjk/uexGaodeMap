package org.zywx.wbpalmstar.plugin.uexgaodemap.VO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ylt on 2016/12/23.
 */
public class SegmentWalkingVO implements Serializable {

    public GaodeGeoPointVO origin; //GaodeGeoPoint 步行起始坐标
    public GaodeGeoPointVO destination; //GaodeGeoPoint 步行终止坐标
    public float distance; //Number 步行总距离(米)
    public long duration; //Number 步行预计时间(秒)
    public List<GaodeStepVO> steps; //Array<GaodeStep> 步行路段


}
