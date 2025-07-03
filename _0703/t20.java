package _0703;
import java.util.Scanner;

public class t20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                continue; // 跳過偶數
            }
            sum += i; // 奇數才加進總和
        }

        System.out.println(sum);
    }
}
