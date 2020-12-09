package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.model.*;

import java.util.List;

/**
 * @author txl
 * @description
 * @date 2020/12/7 19:15
 */
public interface MetadataService {

    /**
     * 插入元数据（在父节点确认的情况下插入）
     * @param metadataDTOList 元数据
     * @return 执行结果
     */
    Boolean insertMetadata(List<MetadataDTO> metadataDTOList);


    Boolean insertOneMetadata(MetadataDTO metadataDTO);


    /**
     * 查询当前结点下的叶子节点
     * @param metadataQuery 查询条件
     * @return 元数据列表
     */
    List<MetadataVO> queryMetadataLeaf(MetadataQuery metadataQuery);

    /**
     * 查询当前结点下的非叶子节点
     * @param metadataQuery 查询条件
     * @return
     */
    List<MetadataVO> queryMetadataWithoutLeaf(MetadataQuery metadataQuery);

    /**
     * 根据元数据类型查找元数据树
     *
     * @param metadataQuery
     * @return 元数据的树形结构
     */
    MetadataTreeVO queryMetadataTree(MetadataQuery metadataQuery);

    /**
     * 根据元数据类型查找元数据树(不含叶子节点)
     * @param metadataQuery
     * @return
     */
    MetadataTreeVO queryTreeWithoutLeaf(MetadataQuery metadataQuery);

    /**
     * 查询当前节点下的所有叶子节点
     * @param metadataQuery
     * @return
     */
    List<MetadataVO> queryChildrenNode(MetadataQuery metadataQuery);

    /**
     * 查询当前节点的深度
     * @param id 元数据的id
     * @return
     */
    Integer queryDepth(Long id);


    /**
     * 删除元数据数据（逻辑删除）
     *
     * @param metadataId 元数据id
     * @return 执行状态
     */
    Boolean deleteMetadata(Long metadataId);

    /**
     * 分页查询元数据
     *
     * @param metadataQuery 元数据查询条件
     * @return 元数据分页数据
     */
    IPage<MetadataVO> queryMetadataPage(MetadataQuery metadataQuery);

    /**
     * 根据元数据id获取元数据详情
     *
     * @param metadataId 元数据id
     * @return 单条元数据记录
     */
    MetadataVO getInfo(Long metadataId);

    /**
     * 更新元数据数据
     *
     * @param metadataDTO 元数据DTO
     * @return 执行状态
     */
    Boolean updateMetadata(MetadataDTO metadataDTO);

    /**
     * 根据标签获得元数据
     *
     * @param label 元数据标签
     * @return 单条元数据记录
     */
    Metadata getByLabel(String label);




}
