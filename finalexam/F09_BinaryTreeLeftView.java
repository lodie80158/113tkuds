package finalexam;

import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}
public class F09_BinaryTreeLeftView {
    public static TreeNode buildTree(String[] data) {
        if (data[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < data.length) {
            TreeNode curr = q.poll();
            if (!data[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(data[i]));
                q.add(curr.left);
            }
            i++;
            if (i < data.length && !data[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(data[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void printLeftView(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == 0) System.out.print(curr.val + " ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        TreeNode root = buildTree(data);
        System.out.print("LeftView: ");
        printLeftView(root);
    }
    /*
     * Time Complexity: O(n)
     * 說明：BFS 過一次所有節點。
     */
}
