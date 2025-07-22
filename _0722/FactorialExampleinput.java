package _0722;


import java.util.Scanner;

public class FactorialExampleinput {

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 建立輸入物件

        System.out.print("請輸入一個非負整數：");
        int input = sc.nextInt(); // 讀取整數

        if (input < 0) {
            System.out.println("錯誤：不接受負數！");
        } else {
            System.out.println(input + "! = " + factorial(input));
        }

        sc.close(); // 關閉 Scanner
    }
}

