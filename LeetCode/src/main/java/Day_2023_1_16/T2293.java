package Day_2023_1_16;

import org.junit.jupiter.api.Test;

/**
 * @author wak
 */
public class T2293 {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] newNums = new int[n >> 1];
        for (int i = 0; i < n >> 1; i++) {
            newNums[i] = (i % 2 == 0) ? Math.min(nums[2 * i], nums[2 * i + 1]) : Math.max(nums[2 * i], nums[2 * i + 1]);
        }
        return minMaxGame(newNums);
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 2, 4, 8, 2, 2};
        System.out.println(minMaxGame(nums));
    }

}
