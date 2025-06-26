package _0626;


public class ds_05 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 8, 10, 4, 6, 9, 1};
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("陣列所有元素的總和為：" + sum);
    }
}
