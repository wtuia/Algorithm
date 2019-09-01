package lint_code.two_num_sum;

import java.util.Arrays;

/**
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 *
 * 回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 */
public class TwoNumSum {

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int target = 9;
        int[] result = checkIndex(a,target);
        System.out.println(Arrays.toString(result));

    }

    private static int[] checkIndex(int [] a, int target) {
        int[] result = new int[2];
        boolean flag = false;
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (a[i] + a[j] == target) {
                    result [0] = i;
                    result [1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }
        return result;
    }

}
