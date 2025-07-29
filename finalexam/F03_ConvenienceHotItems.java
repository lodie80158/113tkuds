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

    // 插入排序，依 qty 從大到小排序
    static void insertionSort(Item[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Item key = arr[i];
            int j = i - 1;
            // 往前比較，qty 大者靠前
            while (j >= 0 && arr[j].qty < key.qty) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int qty = Integer.parseInt(parts[1]);
            items[i] = new Item(name, qty);
        }

        insertionSort(items);

        int limit = Math.min(10, n);
        for (int i = 0; i < limit; i++) {
            System.out.println(items[i].name + " " + items[i].qty);
        }
        sc.close();
    }
}

/*
計算複雜度分析：

1. 使用插入排序對 n 筆資料進行排序，時間複雜度最壞情況為 O(n²)，平均情況亦為 O(n²)。
2. n 最多 200，插入排序效率仍在可接受範圍內，且實作簡單。
3. 輸出前 10 名為常數時間 O(1)。

空間複雜度：
- 儲存資料陣列空間為 O(n)。
- 其他變數空間為常數。

總結：插入排序以簡單且穩定的方式完成排序任務，整體時間複雜度為 O(n²)，空間複雜度為 O(n)，符合本題需求。
*/
