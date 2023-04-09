package Day_2023_2_8;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wak
 */
public class T46 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!set.add(j)) {
                //已经选过了
                continue;
            }
            path.add(nums[j]);
            dfs(nums, i + 1);
            set.remove(j);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(permute(nums));
    }
}
