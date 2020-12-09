package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author txl
 * @description
 * @date 2020/11/12 11:08
 */
@Data
@ApiModel(value = "MetadataVO", description = "元数据视图传出对象")
public class MetadataVO implements Serializable {

    private static final long serialVersionUID = -1692636767868284585L;

    @ApiModelProperty(value = "元数据的主键id")
    private Long id;

    @ApiModelProperty(value = "标签名")
    private String label;

    @ApiModelProperty(value = "类型")
    private String code;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "是否为叶子节点")
    private Boolean isLeaf;

    @ApiModelProperty(value = "拼音检索")
    private String retrieve;

    private Long rightValue;

    private Long leftValue;

}
