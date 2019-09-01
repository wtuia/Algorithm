package lint_code.fizz_buzz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
 *
 * 如果这个数被3整除，打印fizz.
 * 如果这个数被5整除，打印buzz.
 * 如果这个数能同时被3和5整除，打印fizz buzz.
 * 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
 *
 */
public class FizzBuzz {

    public static void main(String[] args) {
        List<String> str = solution(15);
        System.out.println(str.toString());
    }

    @Test
    public void demo1() {
        System.out.println(6%3);
    }

    private static List<String> solution (int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // 在内部比在外部声明快
            String str = null;
            str = i % 3 == 0 ? "fizz" : i + "";
            str = i % 5 == 0 ? "buzz" : str;
            if (i % 3 == 0 && i % 5 == 0) {
               str = "fizz buzz";
            }
            result.add(str);
        }
       return result;
    }

}
