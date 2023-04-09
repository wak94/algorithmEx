package Day_2023_2_8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wak
 */
public class T90 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums, 0, used);
        return ans;
    }

    public void dfs(int nums[], int i, boolean[] used) {
        ans.add(new ArrayList<>(path));
        if (i >= nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j > 0 && nums[j] == nums[j - 1] && !used[j - 1]) {
                continue;
            }
            path.add(nums[j]);
            used[j] = true;
            dfs(nums, j + 1, used);
            used[j] = false;
            path.removeLast();
        }
    }

}
