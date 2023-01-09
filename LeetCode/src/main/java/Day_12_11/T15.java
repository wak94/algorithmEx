package Day_12_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wak
 */
public class T15 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list;
        for (int a = 0; a < n; a++) {
            //保证和前一次枚举的数不一样大
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int c = n - 1;
            int target = -nums[a];
            for (int b = a + 1; b < n; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                //保证b在c的坐边
                while (b < c && nums[b] + nums[c] > target) {
                    c--;
                }
                //如果bc重合，那么当b更大时更加不存在了
                if (b == c) {
                    break;
                }
                if (nums[b] + nums[c] == target) {
                    list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
