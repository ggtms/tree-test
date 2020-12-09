package com.example.demo.util;

/**
 * @author txl
 * @description
 * @date 2020/12/8 0:49
 */
public interface ResultStatus {
    /**
     * 错误码
     * @return
     */
    int getCode();

    /**
     * 错误信息
     * @return
     */
    String getMessage();

}
