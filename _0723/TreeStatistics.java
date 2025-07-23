package _0723;

public class TreeStatistics {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 1. 總和
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    // 2. 最大值
    public static int maxValue(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(maxValue(root.left), maxValue(root.right)));
    }

    // 3. 最小值
    public static int minValue(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(minValue(root.left), minValue(root.right)));
    }

    // 4. 葉節點數量
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 5. 樹的高度
    public static int treeHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }

    public static void main(String[] args) {
        /*
            範例樹：
                   10
                  /  \
                 5    20
                / \     \
               3   7     30
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(30);

        System.out.println("總和：" + sum(root));
        System.out.println("最大值：" + maxValue(root));
        System.out.println("最小值：" + minValue(root));
        System.out.println("葉節點數：" + countLeaves(root));
        System.out.println("樹的高度：" + treeHeight(root));
    }
}

