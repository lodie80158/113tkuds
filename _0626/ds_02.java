package _0626;

import java.util.Scanner;

public class ds_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入圓的半徑：");
        double radius = scanner.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.printf("圓的面積為：%.2f\n", area);
        scanner.close();
    }
}
