package Day_2023_2_6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wak
 */
public class T78 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int i) {
        ans.add(new ArrayList<>(path));
        if (i == nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs(nums, j + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
