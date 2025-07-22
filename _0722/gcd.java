package _0722;

import java.util.Scanner;

public class gcd {

    // 使用遞迴實作歐幾里德演算法
    public static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a); // 結果應為正數
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入第一個整數：");
        int a = sc.nextInt();

        System.out.print("請輸入第二個整數：");
        int b = sc.nextInt();

        int result = gcd(a, b);
        System.out.println("最大公因數為：" + result);

        sc.close();
    }
}
