package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author txl
 * @description
 * @date 2020/12/6 20:53
 */
@Data
public class MetadataDTO {

    @ApiModelProperty(value = "定位码值", example = "code")
    private String locationCode;

    @ApiModelProperty(value = "定位标签名", example = "label")
    private String locationLabel;

    @ApiModelProperty(value = "当前元数据的主键id")
    private Long id;

    private Long leftValue;

    private Long rightValue;

    @ApiModelProperty(value = "数据值", example = "5555")
    private String code;

    @ApiModelProperty(value = "标签名", example = "GB/T")
    private String label;

    @ApiModelProperty(value = "描述", example = "元数据描述")
    private String description;

    @ApiModelProperty(value = "是否为叶子节点(新增节点时不用填写)")
    private Boolean isLeaf;

    @ApiModelProperty(value = "备注信息", example = "备注信息")
    private String remark;

    @ApiModelProperty(value = "检索字段(新增节点时不用填写)")
    private String retrieve;

    public void setMetadataInfo(Long leftValue, Long rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

}
