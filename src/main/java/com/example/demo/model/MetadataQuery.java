package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author txl
 * @description
 * @date 2020/11/12 11:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "MetadataQuery", description = "元数据查询传输对象")
public class MetadataQuery extends PageQuery{

    @ApiModelProperty(value = "元数据主键id")
    private Long id;

    @ApiModelProperty(value = "数据值")
    private String value;

    @ApiModelProperty(value = "元数据代码")
    private String code;

    @ApiModelProperty(value = "标签名")
    private String label;

    @ApiModelProperty(value = "元数据类型")
    private String type;

    @ApiModelProperty(value = "拼音检索（首字母或全拼）")
    private String retrieve;

    @ApiModelProperty(value = "查询的深度")
    private String depth;
    private Boolean havingLeaf;



}
