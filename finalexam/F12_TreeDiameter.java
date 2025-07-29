package finalexam;
import java.util.Scanner;

public class F12_TreeDiameter {
    static int diameter = 0;
    public static int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        TreeNode root = F09_BinaryTreeLeftView.buildTree(data);
        depth(root);
        System.out.println("Diameter: " + diameter);
    }
    /*
     * Time Complexity: O(n)
     * 說明：後續過一次所有節點來計算直徑。
     */
}
