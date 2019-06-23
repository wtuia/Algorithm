package sort.selection;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSortTest {

    public static void main(String[] args) {
        int a[] = {4,5,6,3,2,1};
        a = selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 选择排序
     * @param a
     */
    public static int[] selectionSort(int[] a) {
        int length = a.length, min, temp;

        for (int i = 0 ; i < length ; i++ ) {
            min = i;  // 假设首位为最小

            for (int j = i+1 ; j < length ; j++ ) {
                // 依次比较，找到最小值则交换，并记录下标
                if (a[j] < a[min] ) {
                    min = j;
                }
            }
            // 查找出最小元素交换
            if ( a[min] < a[i]) {
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
        return  a;
    }
}


