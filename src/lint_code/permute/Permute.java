package lint_code.permute;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字列表，返回其所有可能的排列
 */
public class Permute {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> results = solution(nums);
        for (List list : results) {
            System.out.println(list.toString());
        }
    }

    private static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int index = 0, len = nums.length;
        int eachSize = 0;
        while (true) {

            if (index == len) {
                results.add(result);
                result = new ArrayList<>();
                eachSize++;
                index = 0;
            }

            if (eachSize == len) {
                break;
            }

            for (int j = 0; j < len; j++) {
                if (index == 0) {
                    result.add(nums[j]);
                    break;
                } else {
                    // 如果是上一次存入的数，跳过
                    if (result.contains(nums[j])) {
                        continue;
                    }else {
                        result.add(nums[j]);
                        break;
                    }
                }
            }

            index++;
        }
        return results;
    }

    /*
    private void re() {
        for (int i = 0; i < ; i++) {
            for (int j = 0; j < ; j++) {
                for (int k = 0; k < ; k++) {

                }
            }
        }
    }
    */

    /*private static void solution(List<List<Integer>> results,
                                 List<Integer> result,
                          int[] nums, int index) {
        for (int i = 1, len = nums.length ; i <= len; i++) {
            if (index == 0)
                 result = new ArrayList<>();
            result.add(i);
            if(index <= 3){
                solution(results, result, nums, index + 1);
            }
            if (index == 0) {
                results.add(result);
                result = null;
                index = 0;
            }
            }
    }
*/
}
