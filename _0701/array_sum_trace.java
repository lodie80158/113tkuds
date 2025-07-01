package _0701;

public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5}; // 可自訂陣列值
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("加總過程：total = " + total + " + " + arr[i] + " = " + (total + arr[i]));
            total += arr[i];
        }

        System.out.println("總和為：" + total);
/*
 * 時間複雜度分析：
 * 這個演算法使用一個 for 迴圈，依序處理陣列中的每一個元素。
 * 每個元素只被處理一次（加總與輸出），沒有巢狀迴圈或額外操作。
 * 
 * 因此，整體的時間複雜度為：
 *   O(n)
 *   其中 n 是陣列的長度
 *
 * 屬於線性時間（Linear Time），當陣列變大，加總所需的時間也成比例增加。
 */

    }
}

