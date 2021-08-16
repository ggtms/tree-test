package com.example.demo.threadedbinarytree;

/**
 * @author txl
 * @description
 * @date 2021/7/2 9:31
 */
public class ThreadTreeTest {

    public static void main(String[] args) {
        Integer[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // 创建普通二叉树
        ThreadedBinaryTree threadTree = new ThreadedBinaryTree(data);
        // 中序递归遍历二叉树
        threadTree.inList(threadTree.getRoot());
        System.out.println();

        // 采用中序遍历将二叉树线索化
        threadTree.inThreadOrder(threadTree.getRoot());
        threadTree.inThreadList(threadTree.getRoot());
    }

}
