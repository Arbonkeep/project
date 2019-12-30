package com.arbonkeep.service;

/**
 * @author arbonkeep
 * @date 2019/12/30 - 16:42
 * 员工状态类（使用单例模式封装）
 */
public class Status {
    private final String NAME;

    private Status(String name) {
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return getNAME();
    }
}
