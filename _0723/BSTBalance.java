package _0723;

public class BSTBalance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 判斷是否平衡樹，利用遞迴回傳高度與判斷平衡性
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // 回傳節點高度，若不平衡回傳-1
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 2. 計算節點平衡因子（左-右高度）
    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // 3. 找出最不平衡的節點 (最大平衡因子絕對值)
    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        return findMostUnbalancedNodeHelper(root, new int[]{-1});
    }

    private static TreeNode findMostUnbalancedNodeHelper(TreeNode node, int[] maxAbsBalance) {
        if (node == null) return null;

        TreeNode leftCandidate = findMostUnbalancedNodeHelper(node.left, maxAbsBalance);
        TreeNode rightCandidate = findMostUnbalancedNodeHelper(node.right, maxAbsBalance);

        int bf = getBalanceFactor(node);
        int absBf = Math.abs(bf);

        TreeNode candidate = null;
        if (absBf > maxAbsBalance[0]) {
            maxAbsBalance[0] = absBf;
            candidate = node;
        }

        // 比較左右候選節點的平衡度大小
        if (leftCandidate != null) {
            int leftBf = Math.abs(getBalanceFactor(leftCandidate));
            if (leftBf > maxAbsBalance[0]) {
                maxAbsBalance[0] = leftBf;
                candidate = leftCandidate;
            }
        }
        if (rightCandidate != null) {
            int rightBf = Math.abs(getBalanceFactor(rightCandidate));
            if (rightBf > maxAbsBalance[0]) {
                maxAbsBalance[0] = rightBf;
                candidate = rightCandidate;
            }
        }

        return candidate == null ? (absBf > 0 ? node : null) : candidate;
    }

    // --- 輔助印樹（中序）
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // --- 測試
    public static void main(String[] args) {
        /*
             建立不平衡BST：
                 10
                /  \
               5    15
              /      \
             2        20
              \
               3
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(3);
        root.right.right = new TreeNode(20);

        System.out.println("中序遍歷：");
        printInOrder(root);
        System.out.println();

        System.out.println("是否為平衡樹？ " + isBalanced(root));
        System.out.println("節點 5 的平衡因子：" + getBalanceFactor(root.left));
        TreeNode unbalanced = findMostUnbalancedNode(root);
        System.out.println("最不平衡節點的值：" + (unbalanced != null ? unbalanced.val : "無"));
        System.out.println("該節點平衡因子：" + (unbalanced != null ? getBalanceFactor(unbalanced) : "N/A"));
    }
}
