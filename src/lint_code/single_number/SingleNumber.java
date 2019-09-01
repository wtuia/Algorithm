package lint_code.single_number;

public class SingleNumber {
    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,4,4};
        int single = solution(a);
        System.out.println(single);
    }

    private static int solution(int a[]) {
        int len = a.length;
        int tlen = len / 2;
        int[] temp = new int[tlen]; // 存放比较过的元素
        int tempIndex = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            flag = false;
            for (int t = 0; t < tlen; t++) {
                if (i == 0)
                    break;
                if (i == temp[t]) {
                    flag = true;
                    break;
                }
            }
            if (flag) { // 若已比较，则跳过
               continue;
            }
            for (int j = len - 1; j >= i ; j--) {
                if (i == j) {
                    return a[i];
                }
                if (a[i] == a[j]) {
                    temp [tempIndex++] = j;
                    break;
                }
            }
        }
        return 0;
    }
}
