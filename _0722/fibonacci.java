package _0722;

import java.util.Scanner;

public class fibonacci {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入 n：");
        int n = sc.nextInt();
        System.out.println("第 " + n + " 項費波納契數列為：" + fibonacci(n));
        sc.close();
    }
}
