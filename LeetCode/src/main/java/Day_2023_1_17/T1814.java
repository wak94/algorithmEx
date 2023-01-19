package Day_2023_1_17;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author wak
 */
public class T1814 {

    @Test
    public void test() {
        //320999850,0,0,140999850,410996988,-49000149,
        int[] nums = new int[10000000];

        for (int i = 0; i < 10000000; i++) {
            nums[i] = new Random().nextInt();
        }

        System.out.println(countNicePairs(nums));
        System.out.println(countNicePairs1(nums));

    }

    public int countNicePairs1(int[] nums) {
        final int MOD = 1000000007;
        int res = 0;
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i : nums) {
            int temp = i, j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            res = (res + h.getOrDefault(i - j, 0)) % MOD;
            h.put(i - j, h.getOrDefault(i - j, 0) + 1);
        }
        return res;
    }


    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i] - reverse(nums[i]);
            ans = (ans + map.getOrDefault(temp, 0)) % mod;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        return ans;
    }

    private int reverse(int num) {
        int ans = 0;
        while (num > 0) {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return ans;
    }

}
