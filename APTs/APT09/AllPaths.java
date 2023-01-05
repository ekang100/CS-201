import java.util.*;
public class AllPaths {
    ArrayList<String> paths;
    public String[] paths(TreeNode t) {
        // replace with working code
        paths = new ArrayList<>();
        if (t != null && t.left == null && t.right == null) {
            paths.add(String.valueOf(t.info));
        }
        else if (t != null) {
            find(t.left, String.valueOf(t.info));
            find(t.right, String.valueOf(t.info));
        }

        paths.sort(Comparator.naturalOrder());

        String[] ret = new String[paths.size()];
        for (int i = 0; i < paths.size(); i++) {
            String path = paths.get(i);
            ret[i] = path;
        }

        return ret;
    }

    public void find(TreeNode node, String path) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            path = path + "->" + node.info;
            paths.add(path);
        }

        if (node.left != null) {
            find(node.left, path + "->" + node.info);
        }

        if (node.right != null) {
            find(node.right, path + "->" + node.info);
        }
    }
}
