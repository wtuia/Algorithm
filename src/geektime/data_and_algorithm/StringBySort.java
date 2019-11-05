package geektime.data_and_algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://time.geekbang.org/column/article/42038">课后思考</a>
 */
public class StringBySort {

    public static void main(String[] args) {
        String str = "ab12AB34afafqwe34QQFEaa";
        String splitStr = split(str,false);
        String sortStr = split(str,true);
        System.out.printf("%s%n%s%n%s%n",str, splitStr, sortStr);
    }

//-------------------------拆分------------------------------------------------------

    private static String split(String str, boolean isSort) {
        if (isSort)
            str = sort(str);
        StringBuilder sb = new StringBuilder();
        matcher(str, "\\d+", sb);
        matcher(str, "[a-z]+", sb);
        matcher(str, "[A-Z]+", sb);
        return sb.toString();
    }

    private static void matcher(String str, String regex, StringBuilder sb) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            sb.append(m.group());
        }
    }

    //---------------------排序(快排)--------------------------------------------------

    private static String sort(String str) {
        byte[] bytes = str.getBytes();
        byteSort(bytes, 0, bytes.length - 1);
        return new String(bytes);
    }

    private static void byteSort(byte[] bytes, int start, int end) {
        if (start < end) {
            int p = partition(bytes, start, end);
            byteSort(bytes, start, p - 1);
            byteSort(bytes, p + 1, end);
        }
    }

    private static int partition(byte[] bytes, int start, int end) {
        int i = start;
        byte pivot = bytes[end];
        byte temp;
        for (int j = start; j < end; j++) {
            if (bytes[j] < pivot) {
                if (i != j) {
                    temp = bytes[j];
                    bytes[j] = bytes[i];
                    bytes[i] = temp;
                }
                i++;
            }
        }
        if (i != end) {
            temp = bytes[end];
            bytes[end] = bytes[i];
            bytes[i] = temp;
        }
        return i;
    }


}
