package _0723;

import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // --- 輔助：計算節點到根的路徑
    private static boolean getPath(TreeNode root, int target, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root.val == target) return true;

        if (getPath(root.left, target, path) || getPath(root.right, target, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    // 1. 計算任意兩節點距離（節點值）
    public static int distanceBetweenNodes(TreeNode root, int val1, int val2) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        if (!getPath(root, val1, path1) || !getPath(root, val2, path2)) {
            return -1; // 有節點不存在
        }

        // 找最長公共前綴（最近共同祖先）
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }

        // 距離 = (path1剩餘長度) + (path2剩餘長度)
        return (path1.size() - i) + (path2.size() - i);
    }

    // 2. 找樹的直徑（任意兩節點最大距離）
    // 使用兩次DFS法
    public static int treeDiameter(TreeNode root) {
        if (root == null) return 0;

        // 第一次DFS找最遠點
        TreeNode farthest = dfsFindFarthest(root, null, new int[]{0});
        // 第二次DFS從最遠點找距離最大
        int diameter = dfsFindDistance(farthest, null, 0, new int[]{0});
        return diameter;
    }

    private static TreeNode dfsFindFarthest(TreeNode node, TreeNode parent, int[] maxDist) {
        TreeNode farthestNode = node;
        for (TreeNode child : Arrays.asList(node.left, node.right)) {
            if (child != null && child != parent) {
                TreeNode candidate = dfsFindFarthest(child, node, maxDist);
                if (maxDist[0] < getDistance(node, candidate)) {
                    maxDist[0] = getDistance(node, candidate);
                    farthestNode = candidate;
                }
            }
        }
        return farthestNode;
    }

    private static int dfsFindDistance(TreeNode node, TreeNode parent, int dist, int[] maxDist) {
        if (dist > maxDist[0]) {
            maxDist[0] = dist;
        }
        for (TreeNode child : Arrays.asList(node.left, node.right)) {
            if (child != null && child != parent) {
                dfsFindDistance(child, node, dist + 1, maxDist);
            }
        }
        return maxDist[0];
    }

    // 用 BFS 計算兩節點距離（輔助）
    private static int getDistance(TreeNode root, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        queue.offer(root);
        parentMap.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == target) {
                // 計算深度
                int dist = 0;
                while (curr != root) {
                    curr = parentMap.get(curr);
                    dist++;
                }
                return dist;
            }
            if (curr.left != null && !parentMap.containsKey(curr.left)) {
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null && !parentMap.containsKey(curr.right)) {
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
        return -1; // 不存在路徑
    }

    // 3. 找距離根節點指定距離 k 的所有節點
    public static List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        dfsDistanceK(root, 0, k, result);
        return result;
    }

    private static void dfsDistanceK(TreeNode node, int depth, int target, List<Integer> result) {
        if (node == null) return;
        if (depth == target) {
            result.add(node.val);
            return;
        }
        dfsDistanceK(node.left, depth + 1, target, result);
        dfsDistanceK(node.right, depth + 1, target, result);
    }

    // 🧪 測試
    public static void main(String[] args) {
        /*
               1
              / \
             2   3
            /   / \
           4   5   6
                \
                 7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        System.out.println("2 和 7 的距離: " + distanceBetweenNodes(root, 2, 7));  // 4
        System.out.println("樹的直徑: " + treeDiameter(root));  // 5 （路徑: 4-2-1-3-5-7）
        System.out.println("距離根節點 2 的節點: " + nodesAtDistanceK(root, 2)); // [4,5,6]
    }
}

