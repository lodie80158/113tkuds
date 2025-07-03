package _0703;

import java.util.Scanner;

public class t21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble(); // 半徑
        sc.close();

        double area = 3.14 * r * r;

        // 格式化輸出，小數點後兩位
        System.out.printf("%.2f\n", area);
    }
}
