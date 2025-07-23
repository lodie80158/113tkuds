package _0723;
import java.util.*;

public class TreePathProblems {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ✅ 1. 找出所有根到葉的路徑
    public static List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfsAllPaths(root, new ArrayList<>(), result);
        return result;
    }

    private static void dfsAllPaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path)); // 必須複製一份
        } else {
            dfsAllPaths(node.left, path, result);
            dfsAllPaths(node.right, path, result);
        }

        path.remove(path.size() - 1); // 回溯
    }

    // ✅ 2. 判斷是否存在總和為 target 的根到葉路徑
    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == target;
        }
        return hasPathSum(root.left, target - root.val)
            || hasPathSum(root.right, target - root.val);
    }

    // ✅ 3. 找出最大總和的根到葉路徑
    public static List<Integer> maxPathSum(TreeNode root) {
        List<Integer> bestPath = new ArrayList<>();
        dfsMaxPath(root, new ArrayList<>(), 0, new int[]{Integer.MIN_VALUE}, bestPath);
        return bestPath;
    }

    private static void dfsMaxPath(TreeNode node, List<Integer> path, int sum, int[] maxSum, List<Integer> bestPath) {
        if (node == null) return;

        path.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum > maxSum[0]) {
                maxSum[0] = sum;
                bestPath.clear();
                bestPath.addAll(path);
            }
        }

        dfsMaxPath(node.left, path, sum, maxSum, bestPath);
        dfsMaxPath(node.right, path, sum, maxSum, bestPath);

        path.remove(path.size() - 1); // 回溯
    }

    // 🧪 測試
    public static void main(String[] args) {
        /*
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

        // 1️⃣ 所有路徑
        System.out.println("✅ 所有根到葉的路徑：");
        for (List<Integer> path : allPaths(root)) {
            System.out.println(path);
        }

        // 2️⃣ 是否有總和為 22 的路徑？（10→5→7）
        System.out.println("🔍 是否存在總和為 22 的根到葉路徑？ " + hasPathSum(root, 22));

        // 3️⃣ 總和最大的根到葉路徑（10→20→30）
        System.out.println("💰 總和最大路徑為：" + maxPathSum(root));
    }
}
