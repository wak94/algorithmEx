package Day_12_23;

import org.junit.jupiter.api.Test;

/**
 * @author wak
 */
public class T172 {

    /**
     * 优化计算
     *
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

    /**
     * 改进版，由于5更大所以5的幂次肯定更小，只需要计算5的幂次即可
     *
     * @param n
     * @return
     */
    public int trailingZeroes1(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int j = i; j % 5 == 0; j /= 5) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 计算n的阶乘的后缀0个数
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        //2的幂次
        int c2 = 0;
        //5的幂次
        int c5 = 0;
        for (int i = 1; i <= n; i++) {
            c2 += count(2, i);
            c5 += count(5, i);
        }
        return Math.min(c2, c5);
    }

    @Test
    public void test() {
        System.out.println(trailingZeroes(5));
    }

    /**
     * 计算数字n中num的幂
     *
     * @param num 因子
     * @param n   数字
     * @return 幂次
     */
    public int count(int num, int n) {
        if (n % num != 0) {
            return 0;
        }
        int count = 0;
        while (n > 0 && n % num == 0) {
            count++;
            n = n / num;
        }
        return count;
    }
}
