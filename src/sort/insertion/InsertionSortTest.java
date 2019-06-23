package sort.insertion;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSortTest {

    public static void main(String[] args) {
        int[] a = {4,5,6,1,3,2};
        a = insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static int[] insertionSort(int a[]) {
        int length = a.length, value, j;

        // 从第二位开始
        for (int i = 1 ; i < length  ; i++ ) {
            value = a[i];  // 需要插入的值
            j = i-1;       // 插入值的前一位，从后往前比较

            // 依次往前遍历，查找插入位置
            // 若之前的数一直大于比较的数，则一直后移，直到小于或等于为止
            for ( ; j>= 0 ; j-- ) {

                if (a[j] > value ) {
                    a[j+1] = a[j];      // 后移一位
                }else {                 // 找到插入位置，结束
                    break;
                }
            }
            a[j+1] = value; // 插入
        }
        return a;
    }

    /**
     * 无注释版
     * @param a
     * @return
     */
    public static int[] insertionSort1(int a[]) {

        int length = a.length, value, j;

        for (int i = 1 ; i < length  ; i++ ) {
            value = a[i];
            for (j = i-1 ; j>= 0 ; j-- ) {
                if (a[j] > value ) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
        return a;
    }

}
