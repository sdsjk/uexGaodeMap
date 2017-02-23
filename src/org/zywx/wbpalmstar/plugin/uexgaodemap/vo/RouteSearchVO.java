package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;

/**
 * Created by ylt on 2016/12/24.
 */
public class RouteSearchVO implements Serializable{


    public GaodeGeoPointVO origin; //GaodePoint 起始地

    public GaodeGeoPointVO destination;//GaodePoint 目的地

    public int strategy;//Number 路径规划策略,默认0.  0-速度优先（时间）1-费用优先（不走收费路段的最快道路）2-距离优先 3-不走快速路 4-结合实时交通（躲避拥堵）5-多策略（同时使用速度优先、费用优先、距离优先三个策略）6-不走高速 7-不走高速且避免收费 8-躲避收费和拥堵 9-不走高速且躲避收费和拥堵

    public String avoidRoad;//String,可选,避让道路名

    public String city;

    public boolean nightFlag;

}
