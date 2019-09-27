package lint_code.min_stack;

import org.junit.Test;

import java.util.Arrays;

/**
 * 含最小值的简易栈的实现
 */
public class MinStack {

    private int[] stackData;
    private int count;
    private int[] minList = new int[2];
    private int minValue;
    private int maxSize;

    public MinStack() {
        stackData = new int[16];
        maxSize = 16;
        count = 0;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        System.out.printf("最小值：%d\n", stack.min());
        stack.push(2);
        System.out.printf("最小值：%d\n", stack.min());
        stack.push(3);
        System.out.printf("最小值：%d\n", stack.min());
        System.out.printf("弹出：%d\n", stack.pop());
        System.out.printf("弹出：%d\n", stack.pop());
        System.out.printf("弹出：%d\n", stack.pop());
        stack.push(2);
        System.out.printf("最小值：%d\n", stack.min());
        stack.stackToString();
    }

    public void push(int number) {
        if (count == maxSize) {
            maxSize <<= 1;  // 两倍扩容
            stackData = Arrays.copyOf(stackData, maxSize);
        }
        if (minValue == 0) {
            minValue = number;
        }
        stackData[count++] = number;
        minValue = Math.min(minValue, number);

    }

    /*
     * @return: An integer
     */
    public int pop() {
        int value;
        value = stackData[count - 1];
        stackData[--count] = 0; // to let gc do its work
        if (value == minValue) {
            minValue = 0;
            for (int i = 0 ; i < count ; i++) {
                if (i == 0)
                    minValue = stackData[i];
                else
                    minValue = Math.min(minValue, stackData[i]);
            }
        }
        return value;
    }
    /*
     * @return: An integer
     */
    public int min() {
        if (stackData == null || stackData[0] == 0) {
            return 0;
        }
        return minValue;
    }

    public void stackToString(){
        System.out.println(Arrays.toString(stackData));
    }
}
