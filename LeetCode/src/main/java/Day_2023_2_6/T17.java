package Day_2023_2_6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wak
 */
public class T17 {
    public final static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> ans = new ArrayList<>();
    public StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        dfs(digits, 0);
        return ans;
    }

    public void dfs(String digits, int t) {
        if (t == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int index = digits.charAt(t) - '0';
        char[] str = map[index].toCharArray();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
            dfs(digits, t + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
