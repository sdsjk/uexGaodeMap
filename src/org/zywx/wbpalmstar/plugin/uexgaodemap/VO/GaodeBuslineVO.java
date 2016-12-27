package org.zywx.wbpalmstar.plugin.uexgaodemap.VO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ylt on 2016/12/23.
 */
public class GaodeBuslineVO implements Serializable {


    public String uid;           //String 公交线路id
    public String type;          //String 公交类型
    public String name;          //String 公交线路名称
    public String startStop;     //String 首发站
    public String endStop;       //String 终点站
    public String departureStop; //String 启程站
    public String arrivalStop;   //String 下车站
    public List<String> viaStops;      //Array<String> 途径公交站
    public String startTime;     //String 首班车时间
    public String endTime;       //String 末班车时间
    public float distance;      //Number 预计乘坐距离(米)
    public float duration;      //Number 预计乘坐时间(秒)
    public float price;         //Number 票价

}
