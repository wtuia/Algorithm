package sort.bucket;

import sort.RandomArray;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BucketSort {

    public static void main(String[] args) {

        // 生成随机测试数
        System.out.println(System.currentTimeMillis());
        int[] a = RandomArray.getRandomArray(100_000, 1000);
        System.out.println(Arrays.toString(a));
        bucket(a);
        System.out.println(Arrays.toString(a));
        System.out.println(System.currentTimeMillis());

    }


    private static void bucket(int[] nums) {
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (int num : nums) {
            int index = num / 10;
            List<Integer> child = buckets.get(index);
            if (child == null) {
                child = new ArrayList<>();
            }
            child.add(num);
            buckets.put(index, child);
        }
        int len = nums.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            List<Integer> child = buckets.get(i);
            if (child != null) {
                sort(child, 0, child.size() - 1);
                for (Integer integer : child) {
                    nums[index++] = integer;
                }
            }
        }
    }



    private static void sort(List<Integer> a, int start, int end) {
        if (start < end) {
            int p = partition(a, start, end);
            // p点元素确认，排序前后区间
            sort(a, start, p - 1);
            sort(a, p + 1, end);
        }
    }

    private static int partition(List<Integer> a, int start, int end) {
        int povit = a.get(end);
        int i = start;
        int temp;
        for (int j = start; j < end; j++) {
            if (a.get(j) < povit) {
                if (i != j) {
                    temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
                i++;
            }
        }
        if (i != end) {
            temp = a.get(end);
            a.set(end, a.get(i));
            a.set(i, temp);
        }
        return i;
    }
}
