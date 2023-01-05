import java.util.*;
public class UniqueTreeValues {
    TreeSet<Integer> values = new TreeSet<>();
    public int[] unique(TreeNode root) {
        // write code here
        addValue(root);
        int[] ret = new int[values.size()];

        int i = 0;
        for (int value: values) {
            ret[i] = value;
            i++;
        }
        return ret;
    }

    public void addValue(TreeNode root) {
        if (root == null) {
            return;
        }

        values.add(root.info);
        addValue(root.left);
        addValue(root.right);
    }
}