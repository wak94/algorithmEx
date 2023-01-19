package Day_2023_1_16;

import org.junit.jupiter.api.Test;

/**
 * @author wak
 */
public class T1819 {

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        for (int num : nums) {

        }
        return 0;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

    @Test
    public void test() {
        System.out.println(3 % 10);
    }
}
