package finalexam;
import java.util.Scanner;
class BSTNode {
    int val;
    BSTNode left, right;
    BSTNode(int v) { val = v; }
}
public class F10_BSTRangeSum {
    public static int rangeSum(BSTNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSum(root.right, L, R);
        if (root.val > R) return rangeSum(root.left, L, R);
        return root.val + rangeSum(root.left, L, R) + rangeSum(root.right, L, R);
    }
    public static BSTNode insert(BSTNode root, int val) {
        if (root == null) return new BSTNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] vals = sc.nextLine().split(" ");
        int L = sc.nextInt(), R = sc.nextInt();
        BSTNode root = null;
        for (String s : vals) root = insert(root, Integer.parseInt(s));
        System.out.println("Sum: " + rangeSum(root, L, R));
    }
    /*
     * Time Complexity: O(n)
     * 說明：最壞狀況下需要過所有節點。
     */
}
