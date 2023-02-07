package Day_2023_2_7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wak
 */
public class T2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        int[] ans = new int[m];
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            res[i] = res[i - 1] + (check(words[i - 1]) ? 1 : 0);
        }
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = res[r + 1] - res[l];
        }
        return ans;
    }

    public boolean check(String s) {
        String mod = "aeiou";
        return mod.contains(s.charAt(0) + "") && mod.contains(s.charAt(s.length() - 1) + "");
    }
}
