package sort;

import java.util.concurrent.ThreadLocalRandom;

// 生成随机数 以排序
public class RandomArray {

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     *
     * @param len 数组长度
     * @param max 随机值上界
     * @return 随机数数组
     */
    public static int[] getRandomArray(int len, int max) {
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = random.nextInt(max);
        }
        return nums;
    }
}
