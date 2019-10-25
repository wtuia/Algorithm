package lint_code.select_k;

import sort.quick.QuickSortReverse;

import java.util.Arrays;

/**
 * 查找第K大的数, 快排实现
 */
public class SelectK {
    public static void main(String[] args) {
        int[] a = {9,3,2,4,8};
        QuickSortReverse.sort(a, 0 ,a.length - 1);
        System.out.println(Arrays.toString(a)); // 调用快排排序,作参考
        int k = 3; // 第5大的数,从0索引,为 k - 1
        int re = selectMax4k(a,0,a.length-1, k - 1);
        System.out.println(re);
    }
    private static int selectMax4k(int[] a, int start, int end, int index) {
        return sort(a, start, end, index);
    }

    // 找到分区点与index重合则退出，无需全部排序
    private static int sort(int [] a, int start, int end, int index) {
        int result = 0;
        if (start <= end){
            int p = partition(a, start, end); // p点为分区点，比p小的在左边，反之亦然
            if (index < p) {
                result = sort(a, start, p - 1, index);
            }else if(index > p){
                result = sort(a, p + 1, end, index);
            }else{
                result = a[p];
            }
        }
        return  result;
    }
    private static int partition(int [] a, int start, int end) {
        int pivot = a [end];
        int i = start;
        int temp;
        for (int j = start; j < end; j++) {
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
