package geektime.data_and_algorithm.tree;

import sort.RandomArray;

import java.util.Arrays;

/**
 * 完全二叉树
 *
 * 数组模型
 */
public class FullTree {

    public static void main(String[] args) {
        int[] trees = RandomArray.getRandomArray(1000, 10000);
        System.out.println(Arrays.toString(trees));
        preOrder(trees, 1);
    }

    // 先序遍历
    private static void preOrder(int[] trees, int index) {
        if (index >= trees.length)
            return;
        System.out.println(trees[index]);
        preOrder(trees, 2 * index);
        preOrder(trees, 2 * index + 1);
    }


}
