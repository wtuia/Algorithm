package sort.quick;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSortReverse {
    public static void main(String[] args) {
        int[] a = {4,5,6,3,1,8,7,3,2,5};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int [] a, int start, int end) {
        if (start < end){
            int p = partition(a, start, end);
            sort(a, start, p - 1);
            sort(a, p + 1, end);
        }
    }

    private static int partition(int [] a, int start, int end) {
        // 选取中间值,中间值不能包含在i的序列之间,
        // 此处end不会被比较交换,不会打乱已排序的顺序
        int pivot = a [end];
        int i = start;
        int temp;
        for (int j = start; j < end; j++) {
            // 将大数提前, 游标后移,
            // 游标永远大于或大于中间值,
            // 若游标等于中间值,则只能说明,中间值之前的数全都小于中间值
            // 游标一直移动,最后交换的为本身
            if (a[j] > pivot) {
                if (i != j) { //  如果 i == j 移动游标,去除本身交换
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
                i++;
            }
        }
        if (i != end) {
            temp = a[end];  // 交换游标与中间值
            a[end] = a[i];
            a[i] = temp;
        }
        return i;
    }
}
