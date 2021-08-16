package com.example.demo.threadedbinarytree;

import lombok.Data;

/**
 * @author txl
 * @description 线索二叉树
 * @date 2021/7/1 14:08
 */
@Data
public class ThreadedBinaryTree {

    /**
     * 根节点
     */
    private ThreadedBinaryTreeNode root;

    /**
     * 大小
     */
    private Integer size;

    /**
     * 线索化时记录的前一个节点
     */
    private ThreadedBinaryTreeNode preNode = null;

    public ThreadedBinaryTree(Integer[] data)
    {
        this.preNode = null;
        this.size = data.length;
        // 创建二叉树
        this.root = createTree(data, 1);
    }


    void inThreadOrder(ThreadedBinaryTreeNode node) {
        if (node != null) {
            // 线索化左孩子
            inThreadOrder(node.getLeft());
            // 左孩子为空
            if (null == node.getLeft()) {
                // 将左孩子设置为线索
                node.setLeftType(true);
                node.setLeft(preNode);
            }
            // 右孩子为空
            if (preNode != null && null == preNode.getRight()) {
                preNode.setRightType(true);
                preNode.setRight(node);
            }
            preNode = node;
            inThreadOrder(node.getRight());
        }
    }

    /**
     * 前序遍历
     * @param root
     */
    public void preList(ThreadedBinaryTreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.getData() + ",");
            preList(root.getLeft());
            preList(root.getRight());
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inList(ThreadedBinaryTreeNode root)
    {
        if (root != null)
        {
            inList(root.getLeft());
            System.out.print(root.getData() + ",");
            inList(root.getRight());
        }
    }

    /**
     * 中序遍历线索二叉树
     * @param root
     */
    public void inThreadList(ThreadedBinaryTreeNode root)
    {
        if (root != null)
        {
            // 如果左孩子不是线索
            while (root != null && !root.getLeftType())
            {
                root = root.getLeft();
            }
            do
            {
                System.out.print(root.getData() + ",");
                // 如果右孩子是线索
                if (root.getRightType())
                {
                    root = root.getRight();
                }
                else         // 有右孩子
                {
                    root = root.getRight();
                    while (root != null && !root.getLeftType())
                    {
                        root = root.getLeft();
                    }
                }
            } while (root != null);
        }
    }

    /**
     * 创建二叉树
     * @param data 结点数组
     * @param index
     * @return
     */
    public ThreadedBinaryTreeNode createTree(Integer[] data, int index)
    {
        if (index > data.length)
        {
            return null;
        }
        ThreadedBinaryTreeNode node = new ThreadedBinaryTreeNode(data[index - 1]);
        ThreadedBinaryTreeNode left = createTree(data, 2 * index);
        ThreadedBinaryTreeNode right = createTree(data, 2 * index + 1);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

}
