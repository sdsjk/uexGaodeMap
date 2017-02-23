package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ylt on 2017/2/23.
 */

public class QueryProcessedTraceVO implements Serializable {

    public int sequenceLineId;

    public List<TraceLocationVO> traceList;

    public int coordinateType;

}
