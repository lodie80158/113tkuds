package _0703;

import java.util.Scanner;

public class t11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[][] arr = new int[N][M];
        
        // 輸入陣列元素
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        // 計算每列（column）總和
        for (int col = 0; col < M; col++) {
            int colSum = 0;
            for (int row = 0; row < N; row++) {
                colSum += arr[row][col];
            }
            System.out.print(colSum);
            if (col < M - 1) System.out.print(" ");
        }
        
        System.out.println();
        sc.close();
    }
}
