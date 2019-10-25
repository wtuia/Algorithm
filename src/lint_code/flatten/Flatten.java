package lint_code.flatten;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://www.lintcode.com/problem/flatten-list/description">22. 列表扁平化</a>
 *  给定一个列表，该列表中的每个元素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。
 */
public class Flatten {

    public List<Integer> solution(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                result.add(nestedInteger.getInteger());
            } else {
                while (!nestedInteger.isInteger()) {

                }
            }
        }
        return null;
    }

    public static void main(String[] args) {


    }
}
