package lint_code.binary_search;

/**
 * 二分查找有序数组 某数字第一次出现的下标
 * lint code: 14
 */
public class BinarySearch {
/*
4 5 6 1 2 3
5 6 1 2 3 4
3 4 5 6 1 2
 */
    public static void main(String[] args) {
        //int[] nums = {0,1,2,4,4,5,6,7,8,9};
        int[] nums = {7,8};
        int taget = 7;
        int index = solution(nums, taget);
        System.out.println(index);
    }

    private static int solution(int[] nums, int target) {
        int start = 0, end = nums.length, half = end >> 1;
        while (start < end){
           if (nums[half] == target) {
               if (half == 0)
                   return half;
               // 判断是否为第一次出现
               while (nums[half -1] == nums[half]) {
                   half--;
               }
               return half;

           } else {
               if (start + 1 == end) {
                   half = start = end;
                   continue;
               }
               if (nums[half] > target) {
                    end = half;
                    half >>= 1;
               } else {
                    start = half;
                    half = (end - start >> 1) + start; // 计算偏移量
               }
           }
        }
        return -1;
    }
}
