package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;
import java.util.List;

public class CustomButtonDisplayResultVO implements Serializable{
    private static final long serialVersionUID = -6865745143683299291L;
    private List<String> successfulIds;
    private List<String> failedIds;

    public List<String> getSuccessfulIds() {
        return successfulIds;
    }

    public void setSuccessfulIds(List<String> successfulIds) {
        this.successfulIds = successfulIds;
    }

    public List<String> getFailedIds() {
        return failedIds;
    }

    public void setFailedIds(List<String> failedIds) {
        this.failedIds = failedIds;
    }
}
