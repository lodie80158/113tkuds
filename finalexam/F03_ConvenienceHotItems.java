package finalexam;
import java.util.Scanner;

public class F03_ConvenienceHotItems {
    static class Item {
        String name;
        int qty;

        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            items[i] = new Item(name, qty);
        }

       
        for (int i = 1; i < n; i++) {
            Item key = items[i];
            int j = i - 1;
            while (j >= 0 && items[j].qty < key.qty) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }

        int limit = Math.min(10, n);
        for (int i = 0; i < limit; i++) {
            System.out.println(items[i].name + " " + items[i].qty);
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：插入排序在最壞和平均情況下皆需雙層迴圈遍歷陣列元素，時間複雜度為 O(n²)。
 */

