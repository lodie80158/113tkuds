package _0703;

import java.util.Scanner;

public class t7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);  // 讀取一個字元
        int ascii = (int) ch;            // 轉成 ASCII 整數值
        System.out.println(ascii);
        sc.close();
    }
}
