package Day_2023_4_9;

/**
 * @author wak
 * 给定一个数组 arr，表示连续 n 天的股价
 * 指标X：任意两天的股价之和 - 两天间隔天数
 * 返回 arr 的最大指标 X
 * arr[i] + i + arr[j] - j
 */
public class MaxX {
    public int maxX(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int n = arr.length;
        int pre = arr[0], ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, arr[i] - i + pre);
            pre = Math.max(pre, arr[i] + i);
        }
        return ans;
    }
}
