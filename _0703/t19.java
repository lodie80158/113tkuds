package _0703;

import java.util.Scanner;

public class t19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break; // 一旦找到因數就不是質數，跳出迴圈
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }

        System.out.println(); // 換行
    }
}
