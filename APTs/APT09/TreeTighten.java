public class TreeTighten {
    public TreeNode tighten(TreeNode t) {
        // replace with working code
        if (t == null) {
            return null;
        }

        if (t.left == null && t.right == null) {
            t.left = tighten(t.left);
            t.right = tighten(t.right);
        }

        if (t.left != null && t.right != null) {
            t.left = tighten(t.left);
            t.right = tighten(t.right);
        }
        if (!((t.left == null && t.right == null) || (t.left != null && t.right != null))) {
            if (t.left != null) {
                t = tighten(t.left);
            }
            else if (t.right != null) {
                t = tighten(t.right);
            }
        }
        return t;
    }

}
