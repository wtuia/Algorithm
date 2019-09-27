package lint_code.dices_sum;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 20: 扔 n 个骰子，向上面的数字之和为 S。给定 n，请列出所有可能的 S 值及其相应的概率。
 *
 *  <ol>
 *      <p><b>感谢以下文章<b/><p/>
 *      <li><a href="https://blog.csdn.net/aphysia/article/details/77855488">骰子求和</a></li>
 *      <li><a href="https://blog.csdn.net/mofushaohua_ln/article/details/77859431">骰子求和</a></li>
 *  <ol/>
 *
 */
public class DicesSum {

    private static final DecimalFormat format = new DecimalFormat(".00");

    public static void main(String[] args) {
        List<Map.Entry<Integer, Double>> result = dicesSum(3);
        System.out.println(result.toString());

    }

    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {

        List<Map.Entry<Integer, Double>> results = new ArrayList<Map.Entry<Integer, Double>>();
        // 第0列无用，为了序号对应
        double[][] f = new double[n + 1][6 * n + 1];
        // 一颗色子的概率，之后色子的概率由之前的概率求得
        for (int i = 1; i <= 6; ++i)
            f[1][i] = 1.0 / 6;

        // 从第二颗开始， 此处，i代表第几颗，j代表n颗色子可能出现的结果（n - 6*n）, k 代表第i颗色子可能出现的结果1-6
        for (int i = 2; i <= n; ++i) {
            // 求每一种结果可能出现的概率
            for (int j = i; j <= 6 * n; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    // j 一定大于k ，第i颗色子的值不可能大于i颗色子的总和
                    if (j > k) {
                        // 假设两颗色子，如果总结果为4，则第二颗的概率结果为：1，2，3，对应第一个的结果为，3，2，1，则有：f(2,1) = f(1,3)+f(1,2)+f(1,1)
                        f[i][j] += f[i - 1][j - k];
                    } else {
                        break;
                    }
                }
                // 求平均值，/6 的主要原因在于上述方法得到的结果为6次的总概率
                f[i][j] /= 6.0;
            }
        }
        for (int i = n; i <= 6 * n; ++i){
            results.add(new AbstractMap.SimpleEntry<Integer, Double>(i, Double.valueOf(format.format(f[n][i]))));
            //results.add(new AbstractMap.SimpleEntry<Integer, Double>(i, f[n][i]));
        }

        return results;
    }

}
