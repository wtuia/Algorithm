package lint_code.min_window;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * todo
 * 无法去除连续性重复，算法设计问题
 */
public class Solution {

    public static void main(String[] args) {
        String source = "faidyfaksdhadhfadufaoidfadfb";
        String target = "asfadbd";
        String result = minWindow(source, target);
    }

    public static String minWindow(String source, String target) {
        String[] sources = source.split("");
        List<String[]> goodStr = new ArrayList<>();
        List<String> targetList = asList(target);
        List<String> matchList= new ArrayList<>(targetList);
        int start= -1, end;
        String prev = "";
        for (int i = 0, len = sources.length; i < len; i++) {
            String s = sources[i];
            if (matchList.contains(s)) {
                if (start == -1) {
                    start = i;
                    prev = s;
                }
                matchList.remove(s);
                if (matchList.isEmpty()) {
                    end = i;
                    String[] newSource = new String[end - start + 1];
                    System.arraycopy(sources, start, newSource, 0, end - start + 1);
                    goodStr.add(newSource);
                    matchList = new ArrayList<>(targetList);
                    start = -1;
                    end = 0;
                }
            }else {
                if (Objects.equals(s, prev)) {
                    start ++;
                }
            }
        }
        String minStr = "";
        int minSize = sources.length;
        for (String[] strings : goodStr) {
            if (strings.length <= minSize) {
                minSize = strings.length;
                minStr =asString(strings);
            }
        }
        System.out.println(minStr);
        return minStr;
    }

    private static String asString(String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (String str: strings) {
            builder.append(str);
        }
        return builder.toString();
    }

    private static List<String> asList(String str) {
        List<String> list = new ArrayList<>();
        for (Character s : str.toCharArray()) {
            list.add(String.valueOf(s));
        }
        return list;
    }
}
