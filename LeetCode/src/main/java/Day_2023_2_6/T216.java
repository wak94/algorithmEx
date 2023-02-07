package Day_2023_2_6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wak
 */
public class T216 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k, 0, 1);
        return ans;
    }

    private void dfs(int n, int k, int sum, int t) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = t; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            dfs(n, k, sum, i + 1);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        dfs(7, 3, 0, 1);
        System.out.println(ans);
    }
}
