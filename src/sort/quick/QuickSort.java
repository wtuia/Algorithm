package sort.quick;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,1,77,0,45,7};
        sort(a, 0 ,a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int [] a, int start, int end) {

        if (start < end){
            int p = partition(a, start, end);
            sort(a, start, p - 1);
            sort(a, p + 1, end);
        }
    }

    private static int partition(int [] a, int start, int end) {
        int pivot = a [end]; // 选取中间值,中间值不能包含在i的序列之间, 此处end不会被比较交换,不会打乱已排序的顺序
        int i = start;
        int temp;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) { // 将小数提前
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        temp = a[end];  // 交换游标与中间值
        a[end] = a[i];
        a[i] = temp;
        return i;
    }
}
