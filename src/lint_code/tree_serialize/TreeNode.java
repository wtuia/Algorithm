package lint_code.tree_serialize;

public class TreeNode {

    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", left=" + left +
                "\n, right=" + right +
                "}";
    }
}
