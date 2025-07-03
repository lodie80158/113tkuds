package _0703;

import java.util.Scanner;

public class t15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 原本行數
        int M = sc.nextInt(); // 原本列數

        int[][] matrix = new int[N][M];

        // 輸入 N×M 矩陣
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 輸出轉置後 M×N 矩陣
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                System.out.print(matrix[i][j]);
                if (i < N - 1) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}
