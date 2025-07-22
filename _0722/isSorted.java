package _0722;

public class isSorted {

    // 遞迴檢查陣列是否升序排列
    public static boolean isSorted(int[] arr, int index) {
        // 終止條件：已到最後或只有一個元素
        if (index >= arr.length - 1) {
            return true;
        }

        // 若當前元素比下一個大，則非升序
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // 遞迴檢查下一對元素
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5};      // true
        int[] test2 = {1, 2, 2, 3, 4};      // true
        int[] test3 = {5, 4, 3, 2, 1};      // false
        int[] test4 = {1};                 // true
        int[] test5 = {1, 3, 2};           // false

        System.out.println(isSorted(test1, 0)); // true
        System.out.println(isSorted(test2, 0)); // true
        System.out.println(isSorted(test3, 0)); // false
        System.out.println(isSorted(test4, 0)); // true
        System.out.println(isSorted(test5, 0)); // false
    }
}

