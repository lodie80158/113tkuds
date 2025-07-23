package _0723;

public class BSTConversion {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 複製一棵樹（深複製）
    public static TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);
        return newNode;
    }

    // 1. BST轉為排序雙向鏈表（中序遍歷連結左右指標）
    static TreeNode head = null, prev = null;
    public static TreeNode bstToDoublyLinkedList(TreeNode root) {
        head = null; 
        prev = null;
        bstToDLLHelper(root);
        return head;
    }

    private static void bstToDLLHelper(TreeNode node) {
        if (node == null) return;
        bstToDLLHelper(node.left);
        if (prev == null) head = node;
        else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        bstToDLLHelper(node.right);
    }

    // 2. 排序陣列轉為平衡BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        return root;
    }

    // 3. BST節點值改為所有 >= 該節點值的節點值總和（累加樹）
    static int cumulativeSum = 0;
    public static void bstToGreaterTree(TreeNode root) {
        cumulativeSum = 0;
        reverseInOrder(root);
    }

    private static void reverseInOrder(TreeNode node) {
        if (node == null) return;
        reverseInOrder(node.right);
        cumulativeSum += node.val;
        node.val = cumulativeSum;
        reverseInOrder(node.left);
    }

    // 輔助：中序遍歷印出樹節點值
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // 輔助：印出雙向鏈表
    public static void printDoublyLinkedList(TreeNode head) {
        System.out.print("Doubly Linked List: ");
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    // 主程式測試
    public static void main(String[] args) {
        // 建立一棵 BST
        TreeNode originalRoot = new TreeNode(5);
        originalRoot.left = new TreeNode(3);
        originalRoot.right = new TreeNode(7);
        originalRoot.left.left = new TreeNode(2);
        originalRoot.left.right = new TreeNode(4);
        originalRoot.right.right = new TreeNode(8);

        // 1. BST -> 雙向鏈表
        TreeNode rootForDLL = cloneTree(originalRoot);
        TreeNode dllHead = bstToDoublyLinkedList(rootForDLL);
        printDoublyLinkedList(dllHead);

        // 2. 排序陣列 -> 平衡 BST
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode balancedBST = sortedArrayToBST(sortedArr);
        System.out.print("Balanced BST inorder: ");
        printInOrder(balancedBST);
        System.out.println();

        // 3. BST -> 累加樹
        TreeNode rootForGreaterTree = cloneTree(originalRoot);
        bstToGreaterTree(rootForGreaterTree);
        System.out.print("Greater Tree inorder: ");
        printInOrder(rootForGreaterTree);
        System.out.println();
    }
}



