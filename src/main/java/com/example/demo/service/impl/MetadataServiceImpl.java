package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.MetadataMapper;
import com.example.demo.model.*;
import com.example.demo.service.MetadataService;
import com.example.demo.util.BeanUtil;
import com.example.demo.util.BusinessException;
import com.example.demo.util.CommonResultStatus;
import cn.hutool.extra.pinyin.PinyinUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author txl
 * @description
 * @date 2020/12/7 19:16
 */
@Service
public class MetadataServiceImpl extends ServiceImpl<MetadataMapper, Metadata> implements MetadataService {

    @Resource
    private MetadataMapper metadataMapper;

    /**
     * 系统元数据（系统内部使用，用户不可添加）
     */
    private static final String SYS = "SYS";

    /**
     * 元数据类型（所有常规元数据的父元数据）
     */
    private static final String METADATA_TYPE = "METADATA";
    private static final String METADATA_LABEL = "0";
    /**
     * 标识是否为叶子节点节点
     */
    private static final Long IS_LEAF = 1L;
    /**
     * 前端查询元数据树结果集的要求
     */
    private static final String ONLY_LEAF = "ONLY_LEAF";
    private static final String EXCLUDE_LEAF = "EXCLUDE_LEAF";
    private static final String ALL = "ALL";


    @Override
    @Transactional
    public Boolean insertMetadata(List<MetadataDTO> metadataDTOList) {
        metadataDTOList.forEach(metadataDTO -> {
            if (SYS.equals(metadataDTO.getLabel())) {
                throw new BusinessException(CommonResultStatus.CREATE_METADATA_FAIL_UNAUTHORIZED);
            }
            // 根据code与label确定新增节点的位
            Metadata metadata = metadataMapper.selectByLabelAndCode(metadataDTO.getLocationLabel(), metadataDTO.getLocationCode());
            if (metadata == null) {
                throw new BusinessException(CommonResultStatus.GET_FAIL);
            }
            // 考虑新增节点情况
            // 在叶子节点下新增节点
            if (metadata.getRightValue() - metadata.getLeftValue() == IS_LEAF) {
                // 更新树结构（库）中所有大于父节点的右值的节点
                metadataMapper.updateLeftByLeft(metadata.getLeftValue());
                metadataMapper.updateRightByLeft(metadata.getLeftValue());
            } else {
                // 在非叶子节点下新增节点
                metadataMapper.updateLeftByRight(metadata.getRightValue());
                metadataMapper.updateRightByRight(metadata.getRightValue());
            }
            // 设置左、右值
            metadataDTO.setMetadataInfo(metadata.getRightValue(), metadata.getRightValue() + 1);
            // 拼音转检索
            metadataDTO.setRetrieve(this.pinyinConvert(metadataDTO.getDescription()));
        });
        List<Metadata> metadataList = BeanUtil.copyCollections(metadataDTOList, Metadata.class);
        return saveBatch(metadataList);
    }

    @Override
    @Transactional
    public Boolean insertOneMetadata(MetadataDTO metadataDTO){
        if (SYS.equals(metadataDTO.getLabel())) {
            throw new BusinessException(CommonResultStatus.CREATE_METADATA_FAIL_UNAUTHORIZED);
        }
        // 确定新增节点的位置，根据code与label
        Metadata metadata = metadataMapper.selectByLabelAndCode(metadataDTO.getLocationLabel(), metadataDTO.getLocationCode());
        if (metadata == null) {
            throw new BusinessException(CommonResultStatus.GET_FAIL);
        }
        // 考虑新增节点情况
        // 在叶子节点下新增节点
        if (metadata.getRightValue() - metadata.getLeftValue() == IS_LEAF) {
            // 更新树结构（库）中所有大于父节点的右值的节点
            metadataMapper.updateLeftByLeft(metadata.getLeftValue());
            metadataMapper.updateRightByLeft(metadata.getLeftValue());
        } else {
            // 在非叶子节点下新增节点
            metadataMapper.updateLeftByRight(metadata.getRightValue());
            metadataMapper.updateRightByRight(metadata.getRightValue());
        }
        metadataDTO.setMetadataInfo(metadata.getRightValue(), metadata.getRightValue() + 1);
        Metadata copyProperties = BeanUtil.copyProperties(metadataDTO, Metadata.class);
        return metadataMapper.insertOne(metadataDTO);
    }

    @Override
    public List<MetadataVO> queryMetadataLeaf(MetadataQuery metadataQuery) {
        // 查询出当前元数据节点的值
        Metadata metadata = metadataMapper.selectByLabelAndCode(metadataQuery.getLabel(), metadataQuery.getCode());
        // 根据left值查出所有子节点
        List<MetadataVO> metadataList = metadataMapper.selectByLeft(metadata);
        // 将非叶子节点过滤返回叶子节点
        return metadataList.stream().filter(metadataVO -> IS_LEAF.equals(metadataVO.getRightValue() - metadataVO.getLeftValue()))
                .collect(Collectors.toList());
    }
    @Override
    public List<MetadataVO> queryMetadataWithoutLeaf(MetadataQuery metadataQuery) {
        // 查询出当前元数据节点的值
        Metadata metadata = metadataMapper.selectByLabelAndCode(metadataQuery.getLabel(), metadataQuery.getCode());
        // 根据left值查出所有子节点
        List<MetadataVO> metadataList = metadataMapper.selectByLeft(metadata);
        // 将叶子节点过滤返回非叶子节点
        return metadataList.stream().filter(metadataVO -> !IS_LEAF.equals(metadataVO.getRightValue() - metadataVO.getLeftValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<MetadataVO> queryChildrenNode(MetadataQuery metadataQuery) {
//        if (metadataQuery.getCode()==null || metadataQuery.getLabel() ==null) {
//            throw new BusinessException(CommonResultStatus.GET_FAIL);
//        }
        Metadata metadata = metadataMapper.selectByLabelAndCode(metadataQuery.getLabel(), metadataQuery.getCode());
        if (metadata == null) {
            throw new BusinessException(CommonResultStatus.GET_FAIL);
        }
        return metadataMapper.selectAllChild(metadata.getLeftValue());
    }

    @Override
    public MetadataTreeVO queryMetadataTree(MetadataQuery metadataQuery) {
        // 查出所有子节点
        Metadata metadata = metadataMapper.selectByLabelAndCode(metadataQuery.getLabel(), metadataQuery.getCode());
        MetadataTreeVO metadataTreeVO = BeanUtil.copyProperties(metadata, MetadataTreeVO.class);
        // 设置叶子节点
        List<MetadataVO> metadataList = metadataMapper.selectByLeft(metadata);
        List<MetadataTreeVO> metadataTreeVOList = BeanUtil.copyCollections(metadataList, MetadataTreeVO.class);
        metadataTreeVO.setChildren(getChildMetadataList(metadataTreeVO, metadataTreeVOList));
        return metadataTreeVO;
    }

    @Override
    public MetadataTreeVO queryTreeWithoutLeaf(MetadataQuery metadataQuery) {
        // 查出所有子节点
        Metadata metadata = metadataMapper.selectByLabelAndCode(metadataQuery.getLabel(), metadataQuery.getCode());
        MetadataTreeVO metadataTreeVO = BeanUtil.copyProperties(metadata, MetadataTreeVO.class);
        // 设置叶子节点
        List<MetadataVO> metadataList = metadataMapper.selectAllWithoutChild(metadata.getLeftValue());
        List<MetadataTreeVO> metadataTreeVOList = BeanUtil.copyCollections(metadataList, MetadataTreeVO.class);
        metadataTreeVO.setChildren(getChildMetadataList(metadataTreeVO, metadataTreeVOList));
        return metadataTreeVO;
    }

    @Override
    public Integer queryDepth(Long id) {
        List<MetadataPartBO> metadataPartBOList = metadataMapper.queryDepth();
        Map<Long, Integer> longLongMap = new HashMap<>(1);
        metadataPartBOList.forEach(x -> {
            if (x.getId().equals(id)) {
                longLongMap.put(id,x.getDepth());
            }
        });
        return longLongMap.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteMetadata(Long metadataId) {
        Metadata metadata = this.getById(metadataId);
        if (metadata == null) {
            throw new BusinessException(CommonResultStatus.GET_FAIL);
        }
        // 判断是否是叶子节点
        if (!IS_LEAF.equals(metadata.getRightValue() - metadata.getLeftValue())) {
            throw new BusinessException(CommonResultStatus.IS_PARENT_NODE);
        }
        // 维护其他节点
        metadataMapper.updateRightWhileDelete(metadata.getRightValue());
        metadataMapper.updateLeftWhileDelete(metadata.getRightValue());
        return this.removeById(metadataId);
    }

    @Override
    public IPage<MetadataVO> queryMetadataPage(MetadataQuery metadataQuery) {
        Page<MetadataVO> page = new Page<>(metadataQuery.getCurrent(), metadataQuery.getSize());
        return metadataMapper.queryPage(page, metadataQuery);
    }

    @Override
    public MetadataVO getInfo(Long metadataId) {
        Metadata metadata = this.getById(metadataId);
        if (metadata == null) {
            System.out.println("异常信息");
        }
        return BeanUtil.copyProperties(metadata, MetadataVO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateMetadata(MetadataDTO metadataDTO) {
        Metadata rootMetadata = metadataMapper.getRoot(METADATA_TYPE);
        // 根节点不允许修改
        if (rootMetadata.getId().equals(metadataDTO.getId())) {
            throw new BusinessException(CommonResultStatus.NO_AUTHORITY);
        }
        // 维护检索字段
        metadataDTO.setRetrieve(this.pinyinConvert(metadataDTO.getDescription()));
        Metadata metadata = BeanUtil.copyProperties(metadataDTO, Metadata.class);
        // 3.更新数据
        return this.updateById(metadata);
    }

    @Override
    public Metadata getByLabel(String label) {
        return metadataMapper.getByLabel(label);
    }

    private List<MetadataTreeVO> getChildMetadataList(MetadataTreeVO currentMetadata, List<MetadataTreeVO> metadataList) {
        return metadataList.stream()
                // 找children
                .filter(metadataTreeVO -> IS_LEAF.equals(metadataTreeVO.getLeftValue() - currentMetadata.getLeftValue())
                        || IS_LEAF.equals(currentMetadata.getRightValue() - metadataTreeVO.getRightValue()))
                // 设置当前节点的children
                .peek(metadataTreeVO -> metadataTreeVO.setChildren(getChildMetadataList(metadataTreeVO, metadataList)))
                .collect(Collectors.toList());
    }

    private List<MetadataTreeVO> getMetadataListWithoutLeaf(MetadataTreeVO currentMetadata, List<MetadataTreeVO> metadataList) {
        return metadataList.stream()
                // 找children
                .filter(metadataTreeVO -> (IS_LEAF.equals(metadataTreeVO.getLeftValue() - currentMetadata.getLeftValue())
                        || IS_LEAF.equals(currentMetadata.getRightValue() - metadataTreeVO.getRightValue()))
                && (!IS_LEAF.equals(metadataTreeVO.getRightValue() - metadataTreeVO.getLeftValue())))
                // 过滤叶子节点
                //.filter(metadataTreeVO -> !IS_LEAF.equals(metadataTreeVO.getRightValue() - metadataTreeVO.getLeftValue()))
                // 设置当前节点的children
                .peek(metadataTreeVO -> metadataTreeVO.setChildren(getChildMetadataList(metadataTreeVO, metadataList)))
                .collect(Collectors.toList());
    }

    /**
     * 汉字转拼音
     * @param list 待待转换目标集合
     */
    public void pinyinConvert(List<Metadata> list) {
        list.forEach(metadata -> {
            String description = metadata.getDescription();
            // 获得首字母
            String desFirstPinyin = PinyinUtil.getFirstLetter(description, "");
            // 获得全拼
            String desFullPinyin = PinyinUtil.getPinyin(description, "");
            metadata.setRetrieve(desFirstPinyin + "_" + desFullPinyin);
        });
    }

    /**
     * 汉字转拼音
     * @param description 待转换目标
     * @return 转换结果
     */
    private String pinyinConvert(String description) {
        // 获得首字母
        String desFirstPinyin = PinyinUtil.getFirstLetter(description, "");
        // 获得全拼
        String desFullPinyin = PinyinUtil.getPinyin(description, "");
        return desFirstPinyin + "_" + desFullPinyin;
    }
}
