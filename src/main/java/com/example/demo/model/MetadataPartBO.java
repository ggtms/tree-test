package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author txl
 * @description
 * @date 2020/12/2 23:34
 */
@Data
@ApiModel(value = "MetadataPartBO", description = "元数据部分对象")
public class MetadataPartBO {

    @ApiModelProperty(value = "元数据id")
    private Long id;

    @ApiModelProperty(value = "深度")
    private Integer depth;

}
