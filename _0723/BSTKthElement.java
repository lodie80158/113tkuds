package _0723;

public class BSTKthElement {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Counter {
        int count = 0;
        int result = -1;
    }

    public static int kthSmallest(TreeNode root, int k) {
        Counter counter = new Counter();
        inorder(root, k, counter);
        return counter.result;
    }

    private static void inorder(TreeNode node, int k, Counter counter) {
        if (node == null || counter.count >= k) return;

        inorder(node.left, k, counter);

        counter.count++;
        if (counter.count == k) {
            counter.result = node.val;
            return;
        }

        inorder(node.right, k, counter);
    }

    public static void main(String[] args) {
        /*
                20
               /  \
             10    30
            / \    / \
           5  15  25  35
         */
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        for (int k = 1; k <= 7; k++) {
            System.out.println("第 " + k + " 小的元素是: " + kthSmallest(root, k));
        }
    }
}

