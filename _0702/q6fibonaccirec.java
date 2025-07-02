package _0702;

// Q6: Recursive Fibonacci - O(2^n)
import java.util.*;
public class q6fibonaccirec {
    static int ops = 0;
    public static int fib(int n) {
        ops++;
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
        System.out.println(ops);
    }
}