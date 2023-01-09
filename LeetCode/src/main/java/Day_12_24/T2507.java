package Day_12_24;

import org.junit.jupiter.api.Test;

/**
 * @author wak
 */
public class T2507 {
    public int smallestValue(int n) {
        while (true) {
            int sum = sum(n);
            if (sum == n) {
                //已经得到结果
                return n;
            } else {
                n = sum;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(smallestValue(15));
    }

    /**
     * n的所有质因数之和
     *
     * @param n 整数
     * @return 和
     */
    public int sum(int n) {
        int ans = 0;
        for (int i = 2; i <= n; ) {
            if (n % i == 0) {
                ans += i;
                n /= i;
            } else {
                i++;
            }
        }
        return ans;
    }
}
