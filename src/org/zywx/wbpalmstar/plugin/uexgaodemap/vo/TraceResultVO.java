package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ylt on 2017/2/23.
 */

public class TraceResultVO implements Serializable {

    public int lineID;

    public int index;

    public List<GaodeGeoPointVO> linePoints;

    public int waitingTime;

    public int distance;

    public String errorInfo;


}
