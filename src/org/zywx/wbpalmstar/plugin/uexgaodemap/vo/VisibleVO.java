package org.zywx.wbpalmstar.plugin.uexgaodemap.vo;

import java.io.Serializable;

public class VisibleVO implements Serializable{
    private static final long serialVersionUID = -4967273793845415202L;

    private boolean visible = true;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
