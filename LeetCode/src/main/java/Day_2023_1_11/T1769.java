package Day_2023_1_11;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wak
 */
public class T1769 {

    @Test
    public void test() {
        String boxes = "001011";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        char[] s = boxes.toCharArray();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                for (int j = 0; j < n; j++) {
                    ans[j] += Math.abs(i - j);
                }
            }
        }
        return ans;
    }
}
