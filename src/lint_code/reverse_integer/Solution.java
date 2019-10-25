package lint_code.reverse_integer;

/**
 * <a href="https://www.lintcode.com/problem/reverse-3-digit-integer/description">
 *     37.反转一个三位数</a>
 */
public class Solution {


    public static void main(String[] args) {
        int reverseNum = reverseInteger(123);
        int reverseNum1 = reverseInteger(567);
        System.out.println(reverseNum);
        System.out.println(reverseNum1);
    }

    private static int reverseInteger(int number) {
        int one, ten, hun, huns;
        hun = number / 100;
        huns = number % 100;
        ten = huns / 10;
        one = huns % 10;
        return one * 100 + ten * 10 + hun;
    }

    private static int reverseInteger1(int number) {
        int huns;
        huns = number % 100;
        return huns % 10 * 100 + huns / 10 * 10 + number / 100;
    }
}

