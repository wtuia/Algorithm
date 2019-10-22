package lint_code.trailing_zeros;

/**
 * <a href="https://www.lintcode.com/problem/trailing-zeros/description">尾部的零</a>
 * todo
 * O(n) 过高的时间复杂度
 */
public class Solution {

    public static void main(String[] args) {
        long count = trailingZeros(105);
        System.out.println(count);
    }

    private static long trailingZeros(long n) {
        long factorial = 1, mod = 10, count = 0;
      /*
        for (int i = 1 ; i <= n; i++) {
            if (i%100000 == 0){
                System.out.println(i);
            };
            if (list.contains(i%10)) {continue;}
           factorial *= i;
           if (factorial % mod == 0) {
               while (factorial % mod == 0) {
                   count ++;
                   factorial /= 10;
                   System.out.println(factorial);
               }
               factorial %= 10;
           }
        }*/
        for (long left = 1,right = n; left <= right; left++, right--) {
            factorial *= left * right;
            while (factorial % mod == 0) {
                count ++;
                factorial /= 10;
            }
            factorial %= 10;
        }
        return count;
    }


}
