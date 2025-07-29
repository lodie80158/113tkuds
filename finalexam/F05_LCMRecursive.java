package finalexam;

import java.util.Scanner;

public class F05_LCMRecursive {

    
    static int gcd(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcd(a - b, b);
        } else {
            return gcd(a, b - a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcdVal = gcd(a, b);
        long lcm = (long) a * b / gcdVal;

        System.out.println("LCM: " + lcm);

        sc.close();
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：輾轉相減法在最壞情況下每次遞迴會減少其中一個數字 1，故時間複雜度為 O(max(a, b))。
 * 與輾轉相除法相比效率較低，但邏輯簡單易理解。
 */

