package _0703;

import java.util.Scanner;

public class t24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        long factorial = 1;
        int i = 1;

        while (i <= N) {
            factorial *= i;
            i++;
        }

        System.out.println(factorial);
    }
}
