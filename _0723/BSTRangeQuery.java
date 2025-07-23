package _0723;

import java.util.ArrayList;

public class BSTRangeQuery {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderRange(root, min, max, result);
        return result;
    }

    private static void inOrderRange(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;

        // 左子樹只有在 node.val > min 時才有可能包含範圍內值
        if (node.val > min) {
            inOrderRange(node.left, min, max, result);
        }

        if (node.val >= min && node.val <= max) {
            result.add(node.val);
        }

        // 右子樹只有在 node.val < max 時才有可能包含範圍內值
        if (node.val < max) {
            inOrderRange(node.right, min, max, result);
        }
    }

    public static void main(String[] args) {
        /*
               20
              /  \
             10   30
            / \   / \
           5  15 25 35
         */
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        ArrayList<Integer> result = rangeQuery(root, 12, 27);
        System.out.println("範圍查詢結果：" + result); // 預期輸出：[15, 20, 25]
    }
}

