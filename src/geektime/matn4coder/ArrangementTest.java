package geektime.matn4coder;

import java.util.ArrayList;
import java.util.List;

/**
 * 07 排序 思考题
 */
public class ArrangementTest {
    private static List<String> pass = new ArrayList<String>(){{
        add("a");add("a");add("c");add("e");add("d");
    }};

    public static void main(String[] args) {
        String[] strings = {"a","b","c","d","e"};
        List<String> result = new ArrayList<>();
        checkPass(strings, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void checkPass(String[] strs, List<String> result, List<String> pass) {
        if (result.size() == strs.length) {
            return;
        }
        for (String str : strs) {
            List<String> newResult = new ArrayList<>(result);
            newResult.add(str);
            if (isPass(newResult)) {
                pass.addAll(newResult);
                return;
            }
            checkPass(strs, newResult, pass);
        }
    }

    private static boolean isPass(List<String> str) {
        return pass.equals(str);
    }
}
