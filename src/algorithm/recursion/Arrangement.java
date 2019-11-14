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
        for (int i = 0, len = nums.length; i < len; i++) {
            List<Integer> result = new ArrayList<>();
            result.add(nums[i]);
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
        int countMax = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        allPermutation(nums, result, countMax, results);
        for (List<Integer> list : results) {
            System.out.println(list);
        }
        System.out.println(results.size());
    }

    // 全排列 n 个元素，取n个排序
    private static void allPermutation(int[] nums, List<Integer> num, int max, List<List<Integer>> results) {
        for (int i =0, len = nums.length; i < len ; i++) {
            List<Integer> cycleResult = new ArrayList<>(num);
            if (num.contains(nums[i])) {
                continue;
            }
            cycleResult.add(nums[i]);
            int tryMax = max - 1;
            if (tryMax <= 0) {
                results.add(cycleResult);
                return;
            }
            allPermutation(nums, cycleResult, tryMax, results);
        }
    }

    //-----------------------------含重复元素----------------------------------

    @Test
    public void repeatAllPermutationTest() {
        int[] nums = {1,2,2,3,4,5};
        int countMax = nums.length - 1;
        Set<List<Integer>> results = new HashSet<>();
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
                                             int max, Set<List<Integer>> results) {
        for (int i =0, len = nums.length; i < len ; i++) {
            List<Integer> cycleResult = new ArrayList<>(indexList);
            if (indexList.contains(i)) {
                continue;
            }
            cycleResult.add(i);
            int tryMax = max - 1;
            if (tryMax <= 0) {
                List<Integer> result = new ArrayList<>();
                for (Integer index : indexList) {
                    result.add(nums[index]);
                }
                results.add(result);
                return;
            }
            repeatAllPermutation(nums, cycleResult, tryMax, results);
        }
    }
}
