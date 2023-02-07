package Day_2023_2_6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wak
 */
public class T131 {

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[][] check;

    public List<List<String>> partition(String s) {
        //先预处理，可以不必每次用双指针判断回文
        pre(s);
        dfs(s, 0);
        return ans;
    }

    public void dfs(String s, int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String tmp = s.substring(i, j + 1);
            if (check[i][j]) {
                path.add(tmp);
                //继续分割后面的子串
                dfs(s, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public void pre(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        check = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    check[i][j] = true;
                } else if (j == i + 1) {
                    check[i][j] = (s[i] == s[j]);
                } else {
                    check[i][j] = (s[i] == s[j]) && check[i + 1][j - 1];
                }
            }
        }
    }

    @Test
    public void test() {
        pre("aab");
        dfs("aab", 0);
        System.out.println(ans);
    }
}
