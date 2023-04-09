package Day_2023_4_9;

import java.util.Arrays;

/**
 * @author wak
 * 求将 A B 两个数组变成一样的花费的最少时间
 * 可以做如下两种操作
 * 将一个数列中的数 a 变为 b 花费 |b - a|
 * 将一个数列中的数 a 去掉 花费 |a|
 * 1 <= A.length, B.length <= 2000
 * |Ai|, |Bi| <= 10000
 * <p>
 * 思路分析
 */
public class ChangeToSame {

    /**
     * 递归求解把 A[ai......] 和 B[bi......]变成一样的最小费用
     *
     * @param A  数组A
     * @param ai A数组开始下标
     * @param B  数组B
     * @param bi B数组开始下标
     * @return 最小花费
     */
    public int recursion(int[] A, int ai, int[] B, int bi) {
        if (ai == A.length && bi == B.length) {
            return 0;
        }
        if (ai != A.length && bi == B.length) {
            return Math.abs(A[ai]) + recursion(A, ai + 1, B, bi);
        }
        if (ai == A.length) {
            return Math.abs(B[bi]) + recursion(A, ai, B, bi + 1);
        }
        //删掉A[ai]
        int p1 = Math.abs(A[ai]) + recursion(A, ai + 1, B, bi);
        //删掉B[bi]
        int p2 = Math.abs(B[bi]) + recursion(A, ai, B, bi + 1);
        //同时删掉,p3一定大于等于p4可以抛弃
//        int p3 = Math.abs(A[ai]) + Math.abs(B[bi]) + recursion(A, ai + 1, B, bi + 1);
        //变成另一个数,包含了两数相等的情况
        int p4 = Math.abs(A[ai] - B[bi]) + recursion(A, ai + 1, B, bi + 1);
        return Math.min(Math.max(p1, p2), p4);
    }

    public int minCost(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.abs(A[i - 1]) + dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = Math.abs(B[i - 1]) + dp[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int p1 = Math.abs(A[i - 1]) + dp[i - 1][j];
                int p2 = Math.abs(B[i - 1]) + dp[i][j - 1];
                int p3 = Math.abs(A[i - 1] - B[i - 1]) + dp[i - 1][j - 1];
                dp[i - 1][j - 1] = Math.min(p1, Math.min(p2, p3));
            }
        }

        return dp[n - 1][m - 1];
    }

}
