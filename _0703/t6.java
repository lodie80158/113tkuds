package _0703;

import java.util.Scanner;

public class t6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();       // 讀取整數
        double b = sc.nextDouble(); // 讀取浮點數

        double sum = a + b;         // 自動類型提升：int + double → double

        System.out.printf("%.2f\n", sum); // 輸出保留兩位小數

        sc.close();
    }
}

