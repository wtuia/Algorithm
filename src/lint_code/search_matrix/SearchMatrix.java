package lint_code.search_matrix;

/**
 * 写出一个高效的算法来搜索 m × n矩阵中的值。
 *
 * 这个矩阵具有以下特性：
 *
 * 每行中的整数从左到右是排序的。
 * 每行的第一个数大于上一行的最后一个整数。
 * <a href="https://www.lintcode.com/problem/search-a-2d-matrix/description">搜索二维矩阵</a>
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] ints = {{1,4,5},{6,7,8}};

        System.out.println(solution(ints, 8));
        System.out.println(solution(ints, 1));
    }

    /**
     * 因为矩阵有序，可以先判断在二维矩阵的第几个，之后再二分遍历该矩阵，其：
     * 时间复杂度 = O(m) + O(logN)
     * @param matrix 待搜索的矩阵
     * @param target 搜索的值
     * @return 是否存在
     */
    private static boolean solution(int[][] matrix, int target) {
        for (int[] i : matrix) {
            int max = i.length - 1;
            if (target >= i[0] && target <= i[max]) {
                for (int min = 0;;) {
                    int half = (max + min) / 2;
                    if (i[half] == target) {
                        return true;
                    }
                    if(min >= max) {
                        return false;
                    }
                    if (i[half] > target) {
                        max = half - 1;
                    }else{
                        min = half + 1;
                    }
                }
            }
        }
        return  false;
    }


}
