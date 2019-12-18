package lint_code.tree_serialize;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
 *
 * 如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。
 *
 * 样例 1：
 *
 * 输入：{3,9,20,#,#,15,7}
 * 输出：{3,9,20,#,#,15,7}
 * 解释：
 * 二叉树 {3,9,20,#,#,15,7}，表示如下的树结构：
 * 	  3
 * 	 / \
 * 	9  20
 * 	  /  \
 * 	 15   7
 * 它将被序列化为 {3,9,20,#,#,15,7}
 * 样例 2：
 *
 * 输入：{1,2,3}
 * 输出：{1,2,3}
 * 解释：
 * 二叉树 {1,2,3}，表示如下的树结构：
 *    1
 *   / \
 *  2   3
 * 它将被序列
 */
public class TreeSerialize {

    private static int size;

    public static void main(String[] args) {
        String s = "1,2,3,11,#,4,5,#,#,6,7,#,10,#,#,8,9,#,#,12,13,#,#,#,#,#,14";
        TreeNode node = deserialize(s);
        System.out.println(node);
        String result = serialize(node);
        System.out.println(result);

    }

    /**
     *      1
     *   2                3
     *  11 #    4          5
     *  #  #  6     7   #  10
     *  #     #   8   9
     *  #     #  12 13
     *  #     #   # #  14
     */
    @Test
    public void treeTest() {
        TreeNode node = new TreeNode(3);
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(20);
        node.right = right;
        node.left = left;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        String result = serialize(node);
        TreeNode resultNode = deserialize(result);
        System.out.println(result);
        System.out.println(resultNode);
    }

    @Test
    public void treeTest1() {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left = left;
        String result = serialize(node);
        TreeNode resultNode = deserialize(result);
        System.out.println(result);
        System.out.println(resultNode);

    }

    /**
     * 序列化`
     */
    public static void toSerialize(TreeNode root, int index, String[] nodes) {
        if (index * 2 >= nodes.length){
            return;
        }
        if (root.left == null) {
            nodes[index * 2] = "#";
        }else{
            nodes[index * 2] = String.valueOf(root.left.val);
            toSerialize(root.left, index * 2, nodes);
        }
        if (index*2 + 1 >= nodes.length){
            return;
        }
        if (root.right == null) {
            nodes[index * 2 + 1] = "#";
        }else{
            nodes[index * 2 + 1] = String.valueOf(root.right.val);
            toSerialize(root.right, 2 *index +1, nodes);
        }
    }

    public static String serialize(TreeNode root) {
        getLen(root);
        System.out.println(size);
        String[] nodes = new String[size]; // 加上node主节点和0的保留位
        nodes[1] = String.valueOf(root.val); // 设置主节点的值
        toSerialize(root, 1, nodes);
        StringBuilder sb = new StringBuilder();
        for(String str : nodes) {
            if (str != null) {
                sb.append(str.trim()).append(",");
            }
        }
        String s = sb.toString();
        for (; s.endsWith(",") || s.endsWith("#");) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }


    private static void getLen(TreeNode root) {
        if (root.left != null) {
            getLen(root.left);
            size *= 2;
        }
        if (root.right != null) {
             getLen(root.right);
             size += 1;
        }
    }

    /**
     * 反序列化
     */
    public static TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        size = strings.length;
        TreeNode node = new TreeNode(Integer.parseInt(strings[0]));
        reSerialize(strings, node, 1);
        return node;
    }

    public static void reSerialize(String[] strings, TreeNode node, int i) {
        if (i * 2 >= strings.length){
            return;
        }
        if (!Objects.equals("#", strings[i*2 - 1])) {
            node.left = new TreeNode(Integer.parseInt(strings[i*2 - 1]));
            reSerialize(strings, node.left, i*2);
        }
        if (!Objects.equals("#", strings[i*2])) {
            node.right = new TreeNode(Integer.parseInt(strings[i*2]));
            reSerialize(strings, node.right, i*2 + 1);
        }
    }
}
