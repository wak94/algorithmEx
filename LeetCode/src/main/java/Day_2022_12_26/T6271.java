package Day_2022_12_26;

import java.util.Arrays;

/**
 * @author wak
 */
public class T6271 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = (price[price.length - 1] - price[0]) / (k - 1) + 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, price, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public boolean check(int d, int[] price, int k) {
        int cnt = 1, x0 = price[0];
        for (int p : price) {
            if (p >= x0 + d) {
                cnt++;
                x0 = p;
            }
        }
        return cnt >= k;
    }
}
