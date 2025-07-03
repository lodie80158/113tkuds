package _0703;

import java.util.Scanner;

public class t12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        for (int i = 1; i <= N; i++) {
            // 遞增部分 1 ~ i
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                if (j != i || i > 1) {
                    System.out.print(" ");
                }
            }
            // 遞減部分 i-1 ~ 1
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
                if (j != 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
