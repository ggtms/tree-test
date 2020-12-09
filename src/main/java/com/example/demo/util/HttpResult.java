package com.example.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import static com.example.demo.util.Constant.DICK_EMPTY;

/**
 *
 * HTTP结果封装
 * @author txl
 * @description
 * @date 2020/12/7 19:31
 */
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("返回类")
public class HttpResult<T> {
    @Getter
    @Setter
    @ApiModelProperty("code")
    private int code;

    @Getter
    @Setter
    @ApiModelProperty("描述")
    private String msg;

    @Getter
    @Setter
    @ApiModelProperty("对象")
    private T data;

    public static HttpResult<String> error(PublicResultConstant result) {
        return restResultEmpty(result.getResult(),result.getMsg(),DICK_EMPTY);
    }

    public static HttpResult<String> error(String msg) {
        return restResultEmpty(500, msg, DICK_EMPTY);
    }

    public static HttpResult<String> error(int code, String msg) {
        return restResultEmpty(code, msg, DICK_EMPTY);
    }
    public static HttpResult<String> ok(String msg) {
        return restResultEmpty(200, msg, DICK_EMPTY);
    }

    public static <T> HttpResult<T> ok(T data) { return restResult(PublicResultConstant.SUCCESS.getResult(),PublicResultConstant.SUCCESS.getMsg(),data); }

    private static <T> HttpResult<T> restResult(int code, String msg,T data) {
        return new HttpResult<>(code, msg, data);
    }

    private static HttpResult<String> restResultEmpty(int code, String msg,String data) {
        return new HttpResult<>(code, msg, data);
    }
}
