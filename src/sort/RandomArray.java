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

    public static void main(String[] args) {
        String va = "487010695987722";
        String max_val = "2147483647";
       // Long aLong = Long.parseLong(va);
        int integer = Integer.parseInt(max_val);
    }
}
