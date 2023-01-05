public class TreeCount {
    public int count(TreeNode tree) {
        // replace with working code
        if (tree == null) {
            return 0;
        }

        return 1 + count(tree.left) + count(tree.right);
    }
}