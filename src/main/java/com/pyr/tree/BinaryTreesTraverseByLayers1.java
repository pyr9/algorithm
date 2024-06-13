package com.pyr.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.pyr.tree.TreeNode.createBinaryTree;

/**
 * 二叉树按层遍历
 * <p>
 * 递归：
 * 相同层次的节点归入同一个数组
 * 传入辅助的level参数决定层次
 */
public class BinaryTreesTraverseByLayers1 {

    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    @Test
    public void test() {
        LinkedList<Integer> inputList1 = new LinkedList<>(Arrays.asList(1, 2, 3, null, null, 4, 5, null, 6, null, null, 7, null, null));
        TreeNode treeNode = createBinaryTree(inputList1);
        List<List<Integer>> lists = levelOrder(treeNode);
        lists.forEach(sublist -> sublist.forEach(System.out::println));
    }
}
