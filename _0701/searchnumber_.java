
package _0701;
import java.util.Scanner;

public class searchnumber_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("請輸入陣列大小：");
        int n = scanner.nextInt();
        int[] s = new int[n];

        System.out.println("請依序輸入陣列中的 " + n + " 個整數（須為升冪排序）：");
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }


        System.out.print("請輸入要查找的數字：");
        int x = scanner.nextInt();

        int left = 0;
        int right = s.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("比對中：x = " + x + "，中間元素 = " + s[mid]);

            if (s[mid] == x) {
                found = true;
                break;
            } else if (s[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}

