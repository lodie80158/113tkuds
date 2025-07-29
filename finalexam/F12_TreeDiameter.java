package finalexam;
import java.util.*;

public class F12_TreeDiameter {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) return null;
        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < vals.size()) {
            TreeNode curr = queue.poll();
            if (curr == null) continue;

            if (vals.get(i) != -1) {
                curr.left = new TreeNode(vals.get(i));
                queue.offer(curr.left);
            } else {
                curr.left = null;
                queue.offer(null);
            }
            i++;
            if (i >= vals.size()) break;

            if (vals.get(i) != -1) {
                curr.right = new TreeNode(vals.get(i));
                queue.offer(curr.right);
            } else {
                curr.right = null;
                queue.offer(null);
            }
            i++;
        }
        return root;
    }

    static int diameter = 0;

    static int height(TreeNode node) {
        if (node == null) return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        diameter = Math.max(diameter, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        TreeNode root = buildTree(vals);

        diameter = 0;
        height(root);

        System.out.println("Diameter: " + diameter);
        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每節點遞迴訪問一次計算高度並更新直徑，時間複雜度為線性 O(n)。
 */

