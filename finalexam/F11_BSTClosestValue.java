package finalexam;
import java.util.Scanner;
public class F11_BSTClosestValue {
    public static int closest(BSTNode root, int target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target) ||
                (Math.abs(root.val - target) == Math.abs(closest - target) && root.val < closest)) {
                closest = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] vals = sc.nextLine().split(" ");
        int T = sc.nextInt();
        BSTNode root = null;
        for (String s : vals) root = F10_BSTRangeSum.insert(root, Integer.parseInt(s));
        System.out.println("Closest: " + closest(root, T));
    }
    /*
     * Time Complexity: O(h)
     * 說明：每次只去一個方向，最壞狀況為 O(n)，預期 O(log n)。
     */
}
