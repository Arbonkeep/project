package com.arbonkeep.service;

/**
 * @author arbonkeep
 * @date 2020/1/8 - 10:34
 * 异常类
 */
public class TeamException extends Exception {
    static final long serilaVersionUID = -3332342323434533L;

    public TeamException() {}

    public TeamException(String message) {
        super(message);
    }
}
