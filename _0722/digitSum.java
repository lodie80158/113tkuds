package _0722;

public class digitSum {
    public static int digitSum(int n) {
        // 終止條件：一位數直接回傳
        if (n < 10) {
            return n;
        }
        // 遞迴關係：個位數 + 剩下位數的總和
        return (n % 10) + digitSum(n / 10);
    }
    
}
