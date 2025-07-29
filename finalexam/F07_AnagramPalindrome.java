package finalexam;

import java.util.Scanner;

public class F07_AnagramPalindrome {

    static boolean canFormPalindrome(String s) {
        int[] freq = new int[26];
        countLetters(s.toLowerCase(), 0, freq);
        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 != 0) oddCount++;
            if (oddCount > 1) return false;
        }
        return true;
    }

    static void countLetters(String s, int index, int[] freq) {
        if (index == s.length()) return;
        char c = s.charAt(index);
        if (c >= 'a' && c <= 'z') freq[c - 'a']++;
        countLetters(s, index + 1, freq);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(canFormPalindrome(input) ? "Possible" : "Impossible");
        sc.close();
    }
}

/*
 * Time Complexity: O(Σ)
 * 說明：字母頻率計算固定為 26 個字母，為常數時間，整體複雜度為 O(Σ)。
 */
