package lint_code.tree_serialize;

import org.junit.Test;

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

    public static void main(String[] args) {
        TreeSerialize ts = new TreeSerialize();
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.right = right;
        node.left = left;
        left.left = new TreeNode(4);
        right.right = new TreeNode(5);
    }

    @Test
    public void treeTest() {
        TreeNode node = new TreeNode(3);
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(20);
        node.right = right;
        node.left = left;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
    }

    @Test
    public void treeTest1() {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.right = right;
        node.left = left;
        left.left = new TreeNode(4);
        right.right = new TreeNode(5);

    }

    /**
     * 序列化
     */
    public String serialize(TreeNode root) {
        return null;
    }


    /**
     * 反序列化
     */
    public TreeNode deserialize(String data) {

        return null;
    }
}
