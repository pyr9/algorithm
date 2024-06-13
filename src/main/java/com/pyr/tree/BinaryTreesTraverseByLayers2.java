package com.pyr.tree;

import org.junit.Test;

import java.util.*;

import static com.pyr.tree.TreeNode.createBinaryTree;

/**
 * 二叉树按层遍历
 * <p>
 * 迭代：
 * 特例处理： 当根节点为空，则返回空列表 [] 。
 * 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] 。
 * BFS 循环： 当队列 queue 为空时跳出。
 * 新建一个临时列表 tmp ，用于存储当前层打印结果。
 * 当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）。
 * 出队： 队首元素出队，记为 node。
 * 打印： 将 node.val 添加至 tmp 尾部。
 * 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue 。
 * 将当前层结果 tmp 添加入 res 。
 */
public class BinaryTreesTraverseByLayers2 {
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
