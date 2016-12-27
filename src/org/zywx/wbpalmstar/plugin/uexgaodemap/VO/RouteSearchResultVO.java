package org.zywx.wbpalmstar.plugin.uexgaodemap.VO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ylt on 2016/12/24.
 */
public class RouteSearchResultVO<T> implements Serializable {

    public List<T> paths;

    public float taxiCost;

}
