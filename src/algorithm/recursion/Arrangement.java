package algorithm.recursion;

import org.junit.Test;

import java.util.*;

/**
 * 使用递归计算排列
 * <p>对于 n 个元素的全排列，所有可能的排列数量就是 nx(n-1)x(n-2)x…x2x1，也就是 n!;</p>
 * <p>对于 n 个元素里取出 m(0< m ≤n)个元素的不重复排列数量是 nx(n-1)x(n-2)x…x(n - m + 1)，也就是 n!/(n-m)!。</p>
 */
public class Arrangement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int countMax = nums.length - 1;
        List<List<Integer>> results = new ArrayList<>();
        for (int num : nums) {
            List<Integer> result = new ArrayList<>();
            result.add(num);
            allPermutation(nums, result, countMax, results);
        }
        for (List<Integer> list : results) {
            System.out.println(list);
        }
        System.out.println(results.size());
    }

    // 简化调用
    @Test
    public void allPermutationTest() {
        int[] nums = {1,2,3,4,5};
        int tryMax = 2;//nums.length;
        List<List<Integer>> results = new ArrayList<>();
        allPermutation(nums, tryMax, results);
        for (List<Integer> list : results) {
            System.out.println(list);
        }
        System.out.println(results.size());
    }

    // 封装内部实现
    private static void allPermutation(int[] nums, int max, List<List<Integer>> results) {
        allPermutation(nums, new ArrayList<>(), max, results);
    }

    /**
     *全排列 n 个元素，取n个排序
     * @param nums 排列数组
     * @param num 已排列的数组，第一次传入的为一个空数组
     * @param max 最大排列长度
     * @param results 结果
     */
    private static void allPermutation(int[] nums, List<Integer> num, int max, List<List<Integer>> results) {
        for (int i =0, len = nums.length; i < len ; i++) {
            List<Integer> cycleResult = new ArrayList<>(num);
            if (num.contains(nums[i])) {
                continue;
            }
            cycleResult.add(nums[i]);
            int tryMax = max - 1;
            if (tryMax <= 0) { // 当 队列长度 = 排列长度 - 1 时，进入条件
                results.add(cycleResult);
                // 该判断的作用在于，若未全排序，则直接跳出，避免多余的循环
                // 对于非全排序，可以继续查找未在已排序队列的组合，因为是后向查找，则不可能重复。
                // 但无法跳过无用循环，仍需使用 if (num.contains(nums[i])) 排除已存在的数
                if (i +1 == len) {
                    return;
                }else{
                    continue; // 查找可能序列，但不进入下一次递归
                }
            }
            allPermutation(nums, cycleResult, tryMax, results);
        }
    }

    //-----------------------------含重复元素----------------------------------

    @Test
    public void repeatAllPermutationTest() {
        int[] nums = {1,2,2,3,4,5};
        int countMax = nums.length - 1;
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            List<Integer> result = new ArrayList<>();
            result.add(i);
            repeatAllPermutation(nums, result, countMax, results);
        }
        for (List<Integer> list : results) {
            System.out.println(list);
        }
        System.out.println(results.size());
    }

    /**
     *  数组中含有重复元素, 会含有重复数据，使用Set去除，不重复排列
     */
    private static void repeatAllPermutation(int[] nums, List<Integer> indexList,
                                             int max, List<List<Integer>> results) {
        for (int i =0, len = nums.length; i < len ; i++) {
            List<Integer> cycleResult = new ArrayList<>(indexList);
            if (indexList.contains(i)) {
                continue;
            }
            cycleResult.add(i);
            int tryMax = max - 1;
            if (tryMax <= 0) {
                //因为含有重复数据， 使用下标区分
                List<Integer> result = new ArrayList<>();
                for (Integer index : indexList) {
                    result.add(nums[index]);
                }
                if (!results.contains(result)){ //判断去除重复数据， 使用set可达此效果，但set无序
                    results.add(result);
                }
                return;
            }
            repeatAllPermutation(nums, cycleResult, tryMax, results);
        }
    }
}
