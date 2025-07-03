package _0703;
import java.util.Scanner;

public class t16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();              // 陣列長度
        int[] arr = new int[n];            // 宣告陣列

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();         // 讀入陣列元素
        }

        // 反轉輸出
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0) System.out.print(" ");
        }

        System.out.println();
        sc.close();
    }
}
