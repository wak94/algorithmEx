package Day_2022_12_11;

import java.util.Arrays;

/**
 * @author wak
 */
public class T16 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        System.out.println(threeSumClosest(nums, 100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                //比较差值，差值更小就更新答案
                if (Math.abs(sum - target) < Math.abs(temp - target)) {
                    temp = sum;
                }

                //比目标值大，k需要左移到第一个不同的位置
                if (sum > target) {
                    int k0 = k - 1;
                    while (j < k0 && nums[k0] == nums[k]) {
                        k0--;
                    }
                    k = k0;
                } else {
                    //比目标值小，j右移到第一个不同的位置
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        j0++;
                    }
                    j = j0;
                }
            }
        }
        return temp;
    }
}
