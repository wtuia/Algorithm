package sort;

import java.util.Arrays;

/**
 *
 * <a href="https://time.geekbang.org/column/article/42038">计数排序</a>
 * <p>计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计数排序了。
 * 而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。</p>
 */
public class Counting {

    public static void main(String[] args) {
        int[] nums = RandomArray.getRandomArray(10, 10);
        System.out.println(Arrays.toString(nums));
        countSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 倒序则稳定
     */
    private static void countSort1(int[] nums) {
        int max = 0;
        // 查找最大值
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        // 生成 0 - max 的一个数组，存储计数 长度为max + 1 下标为 0 - max
        max++;
        int[] count = new int[max];
        for (int num : nums) {
            count[num]++;
        }

        // 依次累加
        for (int i = 1; i < max; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int len = nums.length;
        int[] result = new int[len];
        // 遍历原数组，按计数位置存入新数组,
        // 计数数组存储的为含自身内前面有多少数，则获取数字存储位置(下标)时，计数应 - 1
        for (int i = len - 1; i >= 0 ; i--) {
            int num = nums[i];
            int index = count[num] - 1;
            count[num]--;
            result[index] = num;
        }
        // 拷贝回原数组
        System.arraycopy(result, 0, nums, 0, len);
    }

    /**
     * 实现之二，直接遍历计数数组，从前往后计数，从前往后存储，稳定
     */
    private static void countSort2(int[] nums) {
        int max = 0;
        // 查找最大值
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        // 生成 0 - max 的一个数组，存储计数 长度为max + 1 下标为 0 - max
        max++;
        int[] counts = new int[max];
        for (int num : nums) {
            counts[num]++;
        }

        int len = nums.length;
        int[] result = new int[len];
        // 遍历计数数组，数组下标为值，值为出现次数，因为下标一定有序，按下标出现次数储存即可
        for (int i = 0, index = 0; i < max; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                result[index++] = i;
            }
        }
        // 拷贝回原数组
        System.arraycopy(result, 0, nums, 0, len);
    }
}
