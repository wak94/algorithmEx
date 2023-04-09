package Day_2023_2_8;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wak
 */
public class T47 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        dfs(nums);
        return ans;
    }

    public void dfs(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (j > 0 && nums[j] == nums[j - 1] && !set.contains(j - 1)) {
                continue;
            }
            //还没选过nums[j]
            if (set.add(j)) {
                path.add(nums[j]);
                dfs(nums);
                set.remove(j);
                path.removeLast();
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        System.out.println(permute(nums));
    }
}
