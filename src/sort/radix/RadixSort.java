package sort.radix;

import sort.RandomArray;

import java.util.*;

/**
 * <p>基数排序</p>
 * <p>求基数:<p/>
 * <ul>
 *     <li>123 / 1 % 10 == 3</li>
 *     <li>123 / 10 % 10 == 2</li>
 *     <li>123 / 100 % 10 == 1</li>
 * </ul>
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] a = RandomArray.getRandomArray(13,100000);
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] nums) {
        int radix = 1, len = nums.length;
        // 基数列表
        Map<Integer, List<Integer>> radixs = new HashMap<>();
        while (true) {
            for (int num : nums) {
                int index = (num / radix) % 10;
                List<Integer> radixNums = radixs.get(index);
                if (radixNums == null) {
                    radixNums = new ArrayList<>();
                }
                radixNums.add(num);
                radixs.put(index, radixNums);
            }
            // 往上求一位
            radix *= 10;
            // 若全部数字在基数0的位置，则说明，所有数字已排序完成
            if (radixs.get(0) !=null && radixs.get(0).size() == len) {
                break;
            }
            // 将每个基数的值排成数组
            int index = 0;
            for (List<Integer> integers : radixs.values()) {
                if ( integers == null || integers.isEmpty()) continue;
                for (Integer integer : integers) {
                    nums[index++] = integer;
                }
            }
            radixs.clear();
        }
        // 赋值给原数组
        int index = 0;
        for (Integer integer : radixs.get(0)) {
            nums[index++] = integer;
        }
    }
}
