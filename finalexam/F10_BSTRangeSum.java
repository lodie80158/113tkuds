package finalexam;
import java.util.*;

public class F10_BSTRangeSum {

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

    static int rangeSum = 0;

    public static void rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return;

        if (root.val > L) rangeSumBST(root.left, L, R);
        if (root.val >= L && root.val <= R) rangeSum += root.val;
        if (root.val < R) rangeSumBST(root.right, L, R);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }

        if (vals.size() < 3) {
            System.out.println("RangeSum: 0");
            sc.close();
            return;
        }

        // 取最後兩個數為 L 和 R
        int R = vals.remove(vals.size() - 1);
        int L = vals.remove(vals.size() - 1);

        TreeNode root = buildTree(vals);

        rangeSum = 0;
        rangeSumBST(root, L, R);

        System.out.println("RangeSum: " + rangeSum);
        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：中序遍歷剪枝後仍可能遍歷全部節點，最壞情況為 O(n)，剪枝可降低不必要遍歷。
 */

