package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ylt on 2016/12/23.
 */
public class GaodePathVO implements Serializable {

    public float distance;

    public long duration;

    public String strategy;
    public float tolls;
    public List<GaodeStepVO> steps;

}
