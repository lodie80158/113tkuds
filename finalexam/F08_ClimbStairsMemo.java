package finalexam;

public class F08_ClimbStairsMemo {
    public static int climb(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo[n] != -1) return memo[n];
        return memo[n] = climb(n - 1, memo) + climb(n - 2, memo) + climb(n - 3, memo);
    }
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n + 1];
        java.util.Arrays.fill(memo, -1);
        System.out.println("Ways: " + climb(n, memo));
    }
    /*
     * Time Complexity: O(n)
     * 說明：記憶化最多計算 n 次。
     */
}
