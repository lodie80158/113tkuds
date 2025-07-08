package _0708;
import java.util.Arrays;

public class ArrayUtility {

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second && num != max) {
                second = num;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.print("原始陣列: ");
        printArray(arr);

        reverseArray(arr);
        System.out.print("反轉後陣列: ");
        printArray(arr);

        int[] copied = copyArray(arr);
        System.out.print("複製陣列: ");
        printArray(copied);

        int secondLargest = findSecondLargest(arr);
        System.out.println("第二大值為: " + secondLargest);
    }
}
