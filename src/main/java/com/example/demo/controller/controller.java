package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.model.MetadataDTO;
import com.example.demo.model.MetadataQuery;
import com.example.demo.model.MetadataTreeVO;
import com.example.demo.model.MetadataVO;
import com.example.demo.service.MetadataService;
import com.example.demo.util.HttpResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author txl
 * @description
 * @date 2020/12/7 18:57
 */
@RestController
public class controller {

    @Resource
    private MetadataService metadataService;

    @PostMapping("/query")
    public HttpResult<MetadataTreeVO> queryTree(MetadataQuery metadataQuery){
        if (metadataQuery.getHavingLeaf()) {
            return HttpResult.ok(metadataService.queryMetadataTree(metadataQuery));
        } else {
            return HttpResult.ok(metadataService.queryTreeWithoutLeaf(metadataQuery));
        }

    }

    @PostMapping("/queryLeaf")
    public HttpResult<List<MetadataVO>> queryLeaf(MetadataQuery metadataQuery){
        return HttpResult.ok(metadataService.queryMetadataLeaf(metadataQuery));
    }
    @PostMapping("/queryWithoutLeaf")
    public HttpResult<List<MetadataVO>> queryWithoutLeaf(MetadataQuery metadataQuery){
        return HttpResult.ok(metadataService.queryMetadataWithoutLeaf(metadataQuery));
    }

    @PostMapping("/queryAll")
    public HttpResult<List<MetadataVO>> queryAll(MetadataQuery metadataQuery){
        return HttpResult.ok(metadataService.queryChildrenNode(metadataQuery));
    }

    @PostMapping("/queryDepth")
    public HttpResult<Integer> queryDepth(MetadataQuery metadataQuery){
        return HttpResult.ok(metadataService.queryDepth(metadataQuery.getId()));
    }

    @PostMapping("/queryPage")
    public HttpResult<IPage<MetadataVO>> queryPage(MetadataQuery metadataQuery){
        return HttpResult.ok(metadataService.queryMetadataPage(metadataQuery));
    }

    @PostMapping("/add")
    public HttpResult<Boolean> add(List<MetadataDTO> metadataDTOList){
        return HttpResult.ok(metadataService.insertMetadata(metadataDTOList));
    }

    @PostMapping("/addOne")
    public HttpResult<Boolean> addOne(MetadataDTO metadataDTO){
        return HttpResult.ok(metadataService.insertOneMetadata(metadataDTO));
    }

    @PutMapping("/updateMetadata")
    public HttpResult<Boolean> updateMetadata(MetadataDTO metadataDTO){
        return HttpResult.ok(metadataService.updateMetadata(metadataDTO));
    }

    @DeleteMapping("/delete")
    public HttpResult<Boolean> hello(Long id){
        return HttpResult.ok(metadataService.deleteMetadata(id));
    }

}
