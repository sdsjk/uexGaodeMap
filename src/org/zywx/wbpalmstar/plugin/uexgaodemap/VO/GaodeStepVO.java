package org.zywx.wbpalmstar.plugin.uexgaodemap.VO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ylt on 2016/12/23.
 */
public class GaodeStepVO implements Serializable {

    public float distance;

    public float duration;
    public String instruction;
    public String orientation;
    public String road;
    public float tolls;
    public String action;

    public List<GaodeGeoPointVO> points;

}
