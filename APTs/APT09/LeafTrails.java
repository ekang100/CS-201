import java.util.*;
public class LeafTrails {
    TreeMap<Integer, String> trails;
    public String[] trails(TreeNode tree) {
        // replace with working code
        trails = new TreeMap<>();

        makeTrail(tree, "");
        String[] ret = new String[trails.size()];

        int i = 0;
        for (String value : trails.values()) {
            ret[i] = value;
            i++;
        }

        return ret;
    }

    public void makeTrail(TreeNode root, String trail) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            trails.put(root.info, trail);
            return;
        }

        makeTrail(root.left, trail + "0");
        makeTrail(root.right, trail + "1");
    }
}
