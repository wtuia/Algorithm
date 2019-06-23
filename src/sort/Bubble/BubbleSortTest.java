package sort.Bubble;

import java.util.Arrays;

/**
 * 冒泡排序
 * O ( n(2) )
 * O ( 1 )
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int[] arr = {6,4,5,2,1,3};
        arr = bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序算法之一
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        // 标志位 ， 当某次无可交换数据时， 表示排序提前完成，提前结束循环
        boolean flag = true;
       int temp, lenght = arr.length;

       for (int i = 0 ; i < lenght ; i++) {

           for (int j = i+1 ; j < lenght ; j++) {
                if (arr[j] < arr[i]) {
                    temp    = arr[i];
                    arr[i]  = arr[j];
                    arr[j]  = temp;
                    flag = false;
                }
           }
           if (flag) break;
       }
        return arr;
    }

    /**
     * 排序算法之二
     * @param arr
     * @return
     */
    public static int[] bubbleSort2(int[] arr) {
        // 标志位 ， 当某次无可交换数据时， 表示排序提前完成，提前结束循环
        boolean flag = true;
        int temp, lenght = arr.length;

        for (int i = 0 ; i < lenght ; i++) {

            for (int j = 0 ; j < lenght - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp     = arr[j];
                    arr[j]   = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
        return arr;
    }

    /**
     * 实现之三
     * 用插入排序的思想冒泡
     */
    public static int[] bubbleSort3(int a[]) {
        int length = a.length, temp;
        // 第一个for表示已排序的空间, 默认为1
        for (int i = 0 ; i < length - 1 ; i++ ) {

            // 将未排序空间的第一位与已排序的比较，依次冒泡
            for (int j = 0 ; j < i+1 ; j++ ) {
                if (a[i+1] < a[j]) {
                    temp   = a[i+1];
                    a[i+1] = a[j];
                    a[j]   = temp;
                }
            }
        }
        return a;
    }

}

