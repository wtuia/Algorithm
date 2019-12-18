package sort.merge;

import java.util.Arrays;

/**
 * 归并排序
 * 先分解 后合并
 *
 * 当前函数运行完之后，会将参数传入下一个本身函数，当前函数的栈被释放。
 * 另见{@link algorithm.fibonacci.Fibonacci}.
 * 对于递归是否会爆栈的判断，在于函数运行完之后，是否需要等待下一个运行获取值，如是，则需要保留栈信息
 *
 *
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] a = {4,5,6,3,2,1};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a){
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int low, int high) {
        int mid =  (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);  // 切割左序列
            sort(a, mid+1, high); // 切割右序列
            merge(a, low, mid, high);  // 合并序列
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1]; // 创建与子序列等长的临时序列
        int i = low, j = mid + 1, k = 0 ;

        while (i <= mid && j <= high ) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // 判断数据剩余
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }

        for (int index = 0, length = temp.length; index < length; index++) {
            a[index+low] = temp[index];
        }
    }

}

