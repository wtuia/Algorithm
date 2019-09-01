package lint_code.merge_sorted_array;

import java.util.Arrays;

/**
 * 合并两个数组， 皆有序
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] a = {1,3,5};
        int[] b = {2,4};
        int[] result = mergeSortedArray(a, b);
        System.out.println(Arrays.toString(result));

    }

    private static int[] mergeSortedArray(int[] A, int[] B) {
        int aLength = A.length;
        int bLength = B.length;
        int[] result = new int[aLength + bLength];
        int aPointer = 0, bPointer = 0, index = 0;
        int aValue, bValue;
        do {
            if (aPointer < aLength) {
                aValue = A[aPointer];
            }else {
                aValue = 0;
            }
            if (bPointer < bLength) {
                bValue = B[bPointer];
            }else {
                bValue = 0;
            }
            if (aValue == 0) {
                if (bValue == 0) {
                    break;
                }else{
                    result[index++] = bValue;
                    bPointer++;
                    continue;
                }
            }
            if (bValue == 0) {
                result[index++] = aValue;
                aPointer++;
                continue;
            }
            if (aValue <= bValue) {
                result [index++] = aValue;
                aPointer++;
            }else{
                result[index++] = bValue;
                bPointer++;
            }
        } while (aPointer < aLength || bPointer < bLength);
        return result;
    }
}
