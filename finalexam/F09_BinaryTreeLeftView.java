package finalexam;

import java.util.*;

public class F09_BinaryTreeLeftView {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode buildTree(List<Integer> values) {
        if (values.isEmpty() || values.get(0) == -1) return null;
        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < values.size()) {
            TreeNode curr = queue.poll();
            if (curr == null) continue;

            // left child
            if (values.get(i) != -1) {
                curr.left = new TreeNode(values.get(i));
                queue.offer(curr.left);
            } else {
                curr.left = null;
                queue.offer(null);
            }
            i++;

            if (i >= values.size()) break;

            // right child
            if (values.get(i) != -1) {
                curr.right = new TreeNode(values.get(i));
                queue.offer(curr.right);
            } else {
                curr.right = null;
                queue.offer(null);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) res.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();
        while (sc.hasNextInt()) {
            values.add(sc.nextInt());
        }
        TreeNode root = buildTree(values);
        List<Integer> leftViewNodes = leftView(root);
        System.out.print("LeftView:");
        for (int v : leftViewNodes) {
            System.out.print(" " + v);
        }
        System.out.println();
        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：建立樹與 BFS 層序遍歷皆遍歷每個節點一次，時間複雜度為 O(n)。
 */

