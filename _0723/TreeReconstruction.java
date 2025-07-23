package _0723;

import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 前序 + 中序重建
    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreInHelper(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1, inMap);
    }

    private static TreeNode buildPreInHelper(int[] pre, int preStart, int preEnd,
                                             int[] in, int inStart, int inEnd,
                                             Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPreInHelper(pre, preStart +1, preStart + leftTreeSize,
                                    in, inStart, inRootIndex -1, inMap);
        root.right = buildPreInHelper(pre, preStart + leftTreeSize +1, preEnd,
                                     in, inRootIndex +1, inEnd, inMap);

        return root;
    }

    // 2. 後序 + 中序重建
    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPostInHelper(postorder, 0, postorder.length -1,
                                inorder, 0, inorder.length -1, inMap);
    }

    private static TreeNode buildPostInHelper(int[] post, int postStart, int postEnd,
                                              int[] in, int inStart, int inEnd,
                                              Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = post[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPostInHelper(post, postStart, postStart + leftTreeSize -1,
                                     in, inStart, inRootIndex -1, inMap);
        root.right = buildPostInHelper(post, postStart + leftTreeSize, postEnd -1,
                                      in, inRootIndex +1, inEnd, inMap);

        return root;
    }

    // 3. 驗證兩棵樹是否相同（結構與值）
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 🧪 測試
    public static void main(String[] args) {
        /*
            原樹：
                  1
                 / \
                2   3
               /   / \
              4   5   6
         */

        int[] preorder =  {1, 2, 4, 3, 5, 6};
        int[] inorder  =  {4, 2, 1, 5, 3, 6};
        int[] postorder = {4, 2, 5, 6, 3, 1};

        TreeNode treeFromPreIn = buildTreePreIn(preorder, inorder);
        TreeNode treeFromPostIn = buildTreePostIn(postorder, inorder);

        // 驗證兩個重建結果相同
        System.out.println("Pre+In 建樹與 Post+In 建樹是否相同: " +
                            isSameTree(treeFromPreIn, treeFromPostIn));

        // 也可以和自己定義的原樹比對
        TreeNode original = new TreeNode(1);
        original.left = new TreeNode(2);
        original.right = new TreeNode(3);
        original.left.left = new TreeNode(4);
        original.right.left = new TreeNode(5);
        original.right.right = new TreeNode(6);

        System.out.println("Pre+In 建樹與原樹相同？ " + isSameTree(treeFromPreIn, original));
        System.out.println("Post+In 建樹與原樹相同？ " + isSameTree(treeFromPostIn, original));
    }
}
