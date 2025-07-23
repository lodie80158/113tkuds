package _0723;

public class TreeComparison {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 判斷兩樹是否完全相同
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 2. 判斷 subRoot 是否為 root 的子樹
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true; // 空樹必為子樹
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 3. 找最大公共子樹 (結構和值完全相同)
    public static TreeNode largestCommonSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return null;

        if (root1.val == root2.val) {
            TreeNode left = largestCommonSubtree(root1.left, root2.left);
            TreeNode right = largestCommonSubtree(root1.right, root2.right);

            TreeNode curr = new TreeNode(root1.val);
            curr.left = left;
            curr.right = right;

            return curr;
        }
        return null;
    }

    // --- 輔助方法：印出樹 (前序遍歷)
    public static void printTree(TreeNode root) {
        printTreeHelper(root, 0);
    }

    private static void printTreeHelper(TreeNode node, int level) {
        if (node == null) return;
        System.out.println("  ".repeat(level) + node.val);
        printTreeHelper(node.left, level + 1);
        printTreeHelper(node.right, level + 1);
    }

    // 🧪 測試
    public static void main(String[] args) {
        /*
         * 樹1：
         *       3
         *      / \
         *     4   5
         *    / \
         *   1   2
         *
         * 樹2：
         *     4
         *    / \
         *   1   2
         */

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);

        // 1. 判斷是否相同
        System.out.println("是否完全相同: " + isSameTree(root1, root2)); // false

        // 2. 判斷是否為子樹
        System.out.println("root2 是否為 root1 子樹: " + isSubtree(root1, root2)); // true

        // 3. 找最大公共子樹
        TreeNode common = largestCommonSubtree(root1, root2);
        System.out.println("最大公共子樹：");
        printTree(common);
    }
}

