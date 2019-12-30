package com.arbonkeep.domain;

/**
 * @author arbonkeep
 * @date 2019/12/30 - 16:23
 */
public class PC implements Equipment {
    private String model;//设备型号
    private String display;//显示器名称

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    //描述设备的方法
    @Override
    public String getDescription() {
        return model + "(" + display +")";
    }
}
