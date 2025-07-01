package _0701;
import java.util.Scanner;

public class linear_search_trace {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9};
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要搜尋的數字：");
        int target = scanner.nextInt();

        boolean found = false;

        for (int num : s) {
            System.out.println("比對中：" + target + " vs " + num);
            if (num == target) {
                found = true;
                break;
            }
        }

        System.out.println("結果：" + (found ? "找到" : "沒找到"));
    }
}
/*
 * 時間複雜度說明：
 * - 最差情況需比對陣列中所有元素，時間複雜度為 O(n)。
 * - 如果目標值在前面，平均次數為 n/2，但仍屬於 O(n)。
 */