package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author txl
 * @description
 * @date 2020/12/6 20:34
 */
public interface MetadataMapper extends BaseMapper<Metadata> {

    /**
     * 通过label、code确定元数据
     * @param label
     * @param code
     * @return
     */
    Metadata selectByLabelAndCode(@Param("label") String label, @Param("code") String code);

    /**
     * 叶子节点下的插入操作前对其他节点的更新
     * @param leftValue
     * @return
     */
    Boolean updateLeftByLeft(@Param("leftValue") Long leftValue);

    Boolean updateRightByLeft(@Param("leftValue") Long leftValue);

    /**
     * 非叶子节点下的插入操作前对其他节点的更新
     * @param rightValue
     * @return
     */
    Boolean updateLeftByRight(@Param("rightValue") Long rightValue);

    Boolean updateRightByRight(@Param("rightValue") Long rightValue);

    /**
     * 通过节点的left找出其左右子节点
     * @param metadata 元数据节点
     * @return
     */
    List<MetadataVO> selectByLeft(@Param("metadata") Metadata metadata);

    /**
     * 查询当前节点下的所有叶子节点
     * @param leftValue
     * @return
     */
    List<MetadataVO> selectAllChild(@Param("leftValue") Long leftValue);

    List<MetadataVO> selectAllWithoutChild(@Param("leftValue") Long leftValue);


    /**
     * 查询元数据的深度
     * @return
     */
    List<MetadataPartBO> queryDepth();

    void updateLeftWhileDelete(@Param("rightValue") Long rightValue);
    /**
     * 有叶子节点删除时更新其他节点的左、右值信息
     * @param rightValue
     */
    void updateRightWhileDelete(@Param("rightValue") Long rightValue);

    /**
     * 批量新增元数据数据
     * @param metadataDTOList 元数据DTO列表
     * @return 影响行数
     */
    Boolean insertBatch(@Param("metadataDTOList") List<MetadataDTO> metadataDTOList);

    Boolean insertOne(@Param("metadataDTO") MetadataDTO metadataDTO);

    /**
     * 根据标签名、类型等分页查询元数据
     * @param page mybatis-plus分页模型
     * @param metadataQuery 查询条件
     * @return 分页记录
     */
    Page<MetadataVO> queryPage(@Param("page") Page page, @Param("metadataQuery") MetadataQuery metadataQuery);

    /**
     * 根据标签名获得实体
     * @param label 元数据标签
     * @return 单条记录
     */
    Metadata getByLabel(@Param("label") String label);

    /**
     * 获取根节点
     * @param label 根节点标签
     * @return 根节点
     */
    Metadata getRoot(@Param("label") String label);
}
