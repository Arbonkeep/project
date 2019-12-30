package com.arbonkeep.domain;

/**
 * @author arbonkeep
 * @date 2019/12/30 - 16:28
 */
public class Printer implements Equipment {
    private String name;//设备名称
    private String type;//设备类型

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //描述设备方法
    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
