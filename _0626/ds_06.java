package _0626;

import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        System.out.print("隨機產生的陣列元素：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100); 
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("陣列中的最大值為：" + max);
    }
}
