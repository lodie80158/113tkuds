package finalexam;

public class F06_ArraySecondLargest {
    public static int[] helper(int[] arr, int l, int r) {
        if (l == r) return new int[]{arr[l], Integer.MIN_VALUE};
        int m = (l + r) / 2;
        int[] left = helper(arr, l, m);
        int[] right = helper(arr, m + 1, r);
        int max, second;
        if (left[0] > right[0]) {
            max = left[0];
            second = Math.max(left[1], right[0]);
        } else {
            max = right[0];
            second = Math.max(right[1], left[0]);
        }
        return new int[]{max, second};
    }
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int[] res = helper(arr, 0, n - 1);
        System.out.println("SecondMax: " + res[1]);
    }
    /*
     * Time Complexity: O(n)
     * 說明：遞迴兩兩比較並向上合併最大與次大值。
     */
}
