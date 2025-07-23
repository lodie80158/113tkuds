package _0723;

import java.util.*;

public class BSTValidation {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ✅ 1. 驗證是否為合法 BST
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBSTHelper(node.left, min, node.val)
            && isValidBSTHelper(node.right, node.val, max);
    }

    // ✅ 2. 找出違規節點（用中序找不遞增）
    public static List<TreeNode> findInvalidNodes(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        TreeNodeWrapper wrapper = new TreeNodeWrapper();
        findInvalidNodesHelper(root, wrapper, result);
        return result;
    }

    static class TreeNodeWrapper {
        TreeNode prev = null;
    }

    private static void findInvalidNodesHelper(TreeNode node, TreeNodeWrapper wrapper, List<TreeNode> result) {
        if (node == null) return;

        findInvalidNodesHelper(node.left, wrapper, result);

        if (wrapper.prev != null && node.val <= wrapper.prev.val) {
            result.add(node);
        }
        wrapper.prev = node;

        findInvalidNodesHelper(node.right, wrapper, result);
    }

    // ✅ 3. 算出最少需要刪除幾個節點才能變成合法 BST
    public static int countNodesToRemoveForValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        collectInorder(root, inorder);
        return inorder.size() - lengthOfLIS(inorder);
    }

    private static void collectInorder(TreeNode node, List<Integer> inorder) {
        if (node == null) return;
        collectInorder(node.left, inorder);
        inorder.add(node.val);
        collectInorder(node.right, inorder);
    }

    // 最長遞增子序列 Longest Increasing Subsequence (LIS)
    private static int lengthOfLIS(List<Integer> nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(dp, num);
            if (i < 0) i = -(i + 1);
            if (i == dp.size()) dp.add(num);
            else dp.set(i, num);
        }
        return dp.size();
    }

    // 🔍 Helper：印出節點 List
    public static void printNodeList(List<TreeNode> nodes) {
        for (TreeNode node : nodes) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    // 🧪 測試入口
    public static void main(String[] args) {
        /*
                10
               /  \
              5    8   <-- 這裡錯了，右子樹不該小於10
             / \    \
            2   7    20
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8); // ❌ 不合法
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        System.out.println("✅ 是否為合法 BST？ " + isValidBST(root));
        System.out.print("🚨 違反 BST 的節點：");
        printNodeList(findInvalidNodes(root));
        System.out.println("🧮 最少需要移除幾個節點才能成為 BST？ " + countNodesToRemoveForValidBST(root));
    }
}

