package com.example.demo.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author txl
 * @description
 * @date 2020/11/12 17:23
 */
@Data
@Api(value = "分页查询条件")
public class PageQuery {

    @ApiModelProperty(value = "页数", example = "1", required = true)
    private int current;

    @ApiModelProperty(value = "每页条数", example = "10", required = true)
    private int size;
    
}
