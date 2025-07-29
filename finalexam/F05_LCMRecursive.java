package finalexam;

public class F05_LCMRecursive {
    public static int gcd(int a, int b) {
        if (a == b) return a;
        return a > b ? gcd(a - b, b) : gcd(a, b - a);
    }
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int g = gcd(a, b);
        System.out.println("LCM: " + (a / g * b));
    }
    /*
     * Time Complexity: O(max(a, b))
     * 說明：使用輾轉相減法遞迴，近似線性遞迴次數。
     */
}
