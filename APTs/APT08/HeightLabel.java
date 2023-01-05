public class HeightLabel {
    public TreeNode rewire(TreeNode t) {
        // replace with working code
        int heightL = 0;
        int heightR = 0;

        if (t.left != null) {
            t.left = rewire(t.left);
            heightL = t.left.info;
        }

        if (t.right != null) {
            t.right = rewire(t.right);
            heightR = t.right.info;
        }

        t.info = 1 + Math.max(heightL, heightR);

        return t;
    }
}
