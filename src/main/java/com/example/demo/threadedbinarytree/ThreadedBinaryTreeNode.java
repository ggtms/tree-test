package com.example.demo.threadedbinarytree;

import lombok.Data;

/**
 * @author txl
 * @description
 * @date 2021/7/1 11:19
 */
@Data
public class ThreadedBinaryTreeNode {
    /**
     * 数据域
     */
    private Integer data;

    /**
     * 左指针域
     */
    private ThreadedBinaryTreeNode left;

    /**
     * 右指针域
     */
    private ThreadedBinaryTreeNode right;

    /**
     * 左指针域类型 false：指向子节点  true：前驱或后继线索
     */
    private Boolean leftType;

    /**
     * 右指针域类型 false：指向子节点、 true：前驱或后继线索
     */
    private Boolean rightType;

    ThreadedBinaryTreeNode(Integer data) {
        this.data = data;
        this.left = null;
        this.leftType = false;
        this.right = null;
        this.rightType = false;
    }




}
