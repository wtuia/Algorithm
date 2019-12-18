package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合，无序的排列
 * <p>对于数据 (1,2)</p>
 * <p>排列: A(1,2) = 2, 含{1,2}和{2,1};</p>
 * <p>组合: C(1,2) = 1</p>
 */
public class Combination {

    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>(Arrays.asList("t1", "t2", "t3")); // 不可变
        combine(teams, new ArrayList<>(), 2);
    }

    private static void combine(ArrayList<String> teams, List<String> result, int m) {
        // 挑选完了m个元素，输出结果
        if (result.size() == m) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < teams.size(); i++) {
            // 从剩下的队伍中，选择一队，加入结果
             List<String> newResult = new ArrayList<>(result);
             newResult.add(teams.get(i));
             // 只考虑当前选择之后的所有情况，避免再次与前面的元素匹配。 后向查找，避免重复
             ArrayList<String> rest_teams = new ArrayList<>(teams.subList(i + 1, teams.size()));
             // 递归调用，对于剩余的情况继续生成组合
            combine(rest_teams, newResult, m);
        }
    }
}

