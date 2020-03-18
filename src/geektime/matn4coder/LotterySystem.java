package geektime.matn4coder;

import java.util.ArrayList;
import java.util.List;

/**
 * 08 组合 思考题
 */
public class LotterySystem {

    public static void main(String[] args) {
        List<Integer> users = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            users.add(i);
        }
        int max = 14;
        int count = 0;
        lottery(users, max, new ArrayList<>(), count);
    }

    private static int lottery(List<Integer> users, int max, List<Integer> results, int count) {
        if (results.size() == max) {
            /*System.out.printf("三等：%s,二等：%s, 一等：%s%n",
                    results.subList(0,10), results.subList(10,13), results.subList(13,14));*/
            return ++count;
        }
        for (int i = 0, len = users.size(); i < len; i++) {
            List<Integer> newResult = new ArrayList<>(results);
            newResult.add(users.get(i));
            List<Integer> newUsers = new ArrayList<>(users. subList(i+1, len));
           count = lottery(newUsers, max, newResult, count);
        }
        return count;
    }
}
