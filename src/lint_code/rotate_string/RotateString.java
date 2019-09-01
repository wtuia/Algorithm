package lint_code.rotate_string;

/**
 * 按偏移量旋转字符串
 * 借用思想 插入排序
 * 原地排序
 */
public class RotateString {

    public static void main(String [] args) {
        String str = new String("abcdefg");
        char[] arrStr = str.toCharArray();
        solution(arrStr, 10);
        String result = new String(arrStr);
        System.out.println(result);
    }


    private static void solution (char[] str, int offset) {
        int len = str.length;
        if (len == 0){
            return;
        }
        if (offset >= len) {
            offset = offset % len;
        }
        int j;
        char value;
        for (int i = len - offset ; i < len ; i++) {
            value = str[i];
            j = i - 1;
            for (int moveLen = len - offset ; moveLen > 0 ; j-- , moveLen-- ) {
                str[j + 1] = str[j];
            }
            str[j + 1] = value;
        }
    }
}
