package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author txl
 * @description
 * @date 2020/12/6 20:06
 */
@Data
@TableName(value = "sys_metadata")
public class Metadata implements Serializable {

    private static final long serialVersionUID = -1692745767868284585L;

    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "代码")
    private String code;

    @ApiModelProperty(value = "标签名")
    private String label;

    @ApiModelProperty(value = "右值")
    private Long rightValue;

    @ApiModelProperty(value = "排序（默认升序）")
    private Long leftValue;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "是否为叶子节点")
    private Boolean isLeaf;

    @ApiModelProperty(value = "拼音检索（全拼或首字母）")
    private String retrieve;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除")
    private Integer delFlag;
}
