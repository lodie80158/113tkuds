package finalexam;
import java.util.*;

public class F11_BSTClosestValue {

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

    public static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == target) return curr.val;

            int currDiff = Math.abs(curr.val - target);
            int closestDiff = Math.abs(closest - target);
            if (currDiff < closestDiff || (currDiff == closestDiff && curr.val < closest)) {
                closest = curr.val;
            }

            if (target < curr.val) curr = curr.left;
            else curr = curr.right;
        }
        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        if (vals.size() < 2) {
            System.out.println("ClosestValue: N/A");
            sc.close();
            return;
        }
        int target = vals.remove(vals.size() - 1);
        TreeNode root = buildTree(vals);

        int res = closestValue(root, target);
        System.out.println("ClosestValue: " + res);
        sc.close();
    }
}

/*
 * Time Complexity: O(h)
 * 說明：BST 搜尋路徑高度為 h，依序比較更新差距並往左或右移動，時間複雜度為 O(h)。
 */

