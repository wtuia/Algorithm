package geektime.matn4coder;

/**
 * 迭代 二分相关操作
 */
public class Binary {

    public static void main(String[] args) {
        double value = getSquare(2, 0.001, 200);
        System.out.println(value);
        double value1 = getSquare(3, 0.0001, 100);
        System.out.println(value1);
    }

    /**
     * 循环计算平方根
     * @param threshold 允许误差
     * @param maxTry 最大尝试次数（避免死锁）
     */
    private static double getSquare(int n, double threshold, int maxTry) {
        if (n <= 1) {return 1; }
        double max = n, middle, min = 1,square, delta;
        for (int i = 0 ; i < maxTry; i++) {
            middle = min + (max - min) / 2;
            square = middle * middle;
            delta =  Math.abs(n - square); //(square / n) - 1
            if (delta <= threshold) {
                return middle;
            }
            if (square > n) {
                max = middle;
            }else{
                min = middle;
            }
        }
        return -1;
    }
}
