package _0703;

import java.util.Scanner;

public class t10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int quotient = a / b;  // 整數除法
        
        System.out.println(quotient);
        
        sc.close();
    }
}
