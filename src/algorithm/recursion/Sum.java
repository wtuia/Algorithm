package algorithm.recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在数组中找出和为指定值的解法
 */
public class Sum {

    public static void main(String[] args) {
        long total = 8;
        long[] nums = {1,2,3,4,5};
        sum(nums, total, new ArrayList<>());
    }

    // 正向
    private static void sum(long[] nums, long total, List<Long> result) {
        if (total == 0) {
            System.out.println(result);
        }else if (total > 0) {
            for (long num : nums) {
                List<Long> newResult = new ArrayList<>(result);
                newResult.add(num);
                sum(nums, total - num, newResult);
            }
        }
        // 若 < 0  此解无效，退出
    }
}
