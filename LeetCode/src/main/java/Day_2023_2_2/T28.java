package Day_2023_2_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wak
 */
public class T28 {

    @Test
    public void test() {
        strStr("sadbutsad", "sad");
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (m < n) {
            return -1;
        }

        char[] s = haystack.toCharArray();
        char[] t = needle.toCharArray();

        int[] next = new int[n];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < n; i++) {
            if (t[i] != t[j]) {
                while (j > 0 && t[i] != t[j]) {
                    j = next[j - 1];
                }
            } else {
                j++;
            }
            next[i] = j;
        }

        System.out.println(Arrays.toString(next));
        j = 0;
        for (int i = 0; i < m; i++) {
            while (j > 0 && s[i] != t[j]) {
                j = next[j - 1];
            }
            if (s[i] == t[j]) {
                j++;
            }
            if (j == n) {
                return i - n + 1;
            }
        }

        return -1;
    }
}
