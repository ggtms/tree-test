package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wsp
 */
@Getter
@AllArgsConstructor
public enum PublicResultConstant {
    /**
     * 异常信息
     */
    FAILED(500, "系统错误,请联系管理员"),
    SUCCESS(200, "success"),
    UNAUTHORIZED(401, "未登录/token过期"),
    ERROR(500, "操作失败"),
    PARAM_ERROR(500, "参数错误"),
    INVALID_USERNAME_PASSWORD(500, "用户名或密码错误"),
    INVALID_RE_PASSWORD(500, "两次输入密码不一致"),
    INVALID_PASSWORD(500, "密码错误"),
    OLD_INVALID_PASSWORD(500, "密码错误"),
    USERNAME_ALREADY_IN(500, "用户已存在"),
    INVALID_USER(500, "用户不存在"),
    QUERY_INVALID(500, "查询失败"),
    INVALID_ROLE(500, "角色不存在"),
    ROLE_USER_USED(500, "角色使用中，不可删除"),
    INVALID_PARAM_EXIST(500, "请求参数已存在"),
    INVALID_PARAM_EMPTY(500, "请求参数为空"),
    CURRENT_USER_INVALID(500, "不能删除当前用户"),
    USER_NO_PERMITION(401, "当前用户无该接口权限"),
    VERIFY_PARAM_ERROR(500, "校验码错误"),
    VERIFY_PARAM_PASS(500, "校验码过期"),
    USER_NO_AUTHORITY(401, "该用户没有权限"),
    MOBILE_ERROR(500, "手机号格式错误"),
    IMG_ERROR(500, "图验证码生成错误"),
    DATA_ERROR(500, "数据操作错误"),
    USER_ID_NULL(500,"用户ID不存在");

    private int result;
    private String msg;
}
