package Day_2023_1_9;

import org.junit.jupiter.api.Test;

/**
 * @author wak
 */
public class T1658 {

    @Test
    public void test() {
        int[] nums = {5, 2, 3, 1, 1};
        System.out.println(minOperations(nums, 5));
    }

    //求最长连续序列和为sum-x
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < x) {
            return -1;
        }
        int len = nums.length;
        int ans = len + 1;
        int right = 0;
        //ls为左边的数之和，rs为右边的数之和
        int ls = 0, rs = sum;
        for (int left = -1; left < len; left++) {
            if (left != -1) {
                ls += nums[left];
            }
            while (right < nums.length && ls + rs > x) {
                rs -= nums[right++];
            }
            if (ls + rs == x) {
                ans = Math.min(ans, left + 1 + len - right);
            }
        }
        return ans > len ? -1 : ans;
    }
}
