package _0626;
import java.util.Scanner;

public class ds_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入第一個整數：");
        int a = scanner.nextInt();
        System.out.print("請輸入第二個整數：");
        int b = scanner.nextInt();
        int sum = a + b;
        System.out.println("兩數之和為：" + sum);
        scanner.close();
    }
}
