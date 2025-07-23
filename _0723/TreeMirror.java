package _0723;

public class TreeMirror {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 1. 是否對稱（根的左右子樹互為鏡像）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return areMirror(root.left, root.right);
    }

    // 2. 將一棵樹鏡像化（左 ↔ 右）
    public static void mirror(TreeNode root) {
        if (root == null) return;
        // Swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 遞迴左右
        mirror(root.left);
        mirror(root.right);
    }

    // 3. 判斷兩棵樹是否互為鏡像
    public static boolean areMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val
            && areMirror(a.left, b.right)
            && areMirror(a.right, b.left);
    }

    // 測試用：中序輸出
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        /*
             1
            / \
           2   2
          / \ / \
         3  4 4  3
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("是否對稱: " + isSymmetric(root)); // true

        mirror(root);
        System.out.print("鏡像後中序遍歷: ");
        printInOrder(root);
        System.out.println();

        // 測試兩棵鏡像
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(3);
        b.right = new TreeNode(2);

        System.out.println("a 和 b 是否互為鏡像: " + areMirror(a, b)); // true
    }
}
 

