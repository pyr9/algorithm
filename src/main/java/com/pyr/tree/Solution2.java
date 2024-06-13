package com.pyr.tree;

import org.junit.Test;

import java.util.*;

import static com.pyr.tree.TreeNode.createBinaryTree;

public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }


    @Test
    public void test() {
        LinkedList<Integer> inputList1 = new LinkedList<>(Arrays.asList(1, 2, 3, null, null, 4, 5, null, 6, null, null, 7, null, null));
        TreeNode treeNode = createBinaryTree(inputList1);
        List<List<Integer>> lists = levelOrder(treeNode);
        lists.forEach(sublist -> sublist.forEach(System.out::println));
    }
}
