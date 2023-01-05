public class PathSum {
    public int hasPath(int target, TreeNode tree){
        // replace with working code
        if (tree == null) {
            return 0;
        }

        if (tree.left == null && tree.right == null && tree.info == target) {
            return 1;
        }

        int need = target - tree.info;

        if (hasPath(need, tree.left) == 1 || hasPath(need, tree.right) == 1) {
            return 1;
        }

        return 0;
    }
}