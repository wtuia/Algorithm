package algorithm.fibonacci;

/**
 * 尾递归 递归 循环 的运行速率比较
 *
 * 对于递归：
 * 当前函数运行完之后，将值传入下一个函数，并保留当前函数栈等待下一个函数返回，层次过深会导致栈溢出
 * 另见{@link sort.merge.MergeSortTest}
 *
 */
public class Fibonacci {

    public static void main(String[] args) {
        int index = 41;
        System.out.println(recursion(index));
      /*  System.out.println(System.currentTimeMillis());
        System.out.println(lastRecursion(index, 0 ,1));
        System.out.println(System.currentTimeMillis());
        System.out.println(recursion(index));
        System.out.println(System.currentTimeMillis());
        System.out.println(loop(index));
        System.out.println(System.currentTimeMillis());*/
    }

    // 递归
    private static long recursion(long index) {
        if (index < 2) {
            return index;
        }
        System.out.println(index);
        // 返回前两数之和
        return recursion(index -1) + recursion(index - 2);
    }

    // 循环
    private static long loop(long index) {
        if (index < 2) {
            return index;
        }
        long preNum = 0, num = 1, temp;
        for (int i = 2; i <= index; i++) {
            temp = num;
            num += preNum;
            preNum = temp;
        }
        return num;
    }

    // 尾递归
    private static long lastRecursion(int index, long per, long num) {
        if (index < 2) {
            return num;
        }
        return lastRecursion(--index, num, per + num);
    }

}
