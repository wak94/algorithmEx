package Day_2023_2_8;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wak
 */
public class T491 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int i) {
        if (path.size() > 1) {
            ans.add(new ArrayList<>(path));
        }
        if (i >= nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            int num = nums[j];
            //如果添加成功，那么可以进行递归，也就是当前层还没有遍历这个数
            if (!path.isEmpty() && num < path.getLast()) {
                continue;
            }
            if (!set.add(num)) {
                continue;
            }
            path.add(num);
            dfs(nums, j + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }
}
