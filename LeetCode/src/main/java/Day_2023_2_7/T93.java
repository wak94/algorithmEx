package Day_2023_2_7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wak
 */
public class T93 {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder path = new StringBuilder(s);
        dfs(path, 0, 0);
        return ans;
    }

    public void dfs(StringBuilder s, int startIndex, int count) {
        if (count == 3) {
            //判断第四段是否合法
            if (check(s, startIndex, s.length() - 1)) {
                ans.add(s.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //选取从startIndex到i的字符串
            if (check(s, startIndex, i)) {
                s.insert(i + 1, '.');
                count++;
                dfs(s, i + 2, count);
                count--;
                s.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    public boolean check(StringBuilder s, int start, int end) {
        char[] str = s.toString().toCharArray();
        if (start > end) {
            return false;
        }
        if (str[start] == '0' && start != end) {
            return false;
        }
        int res = 0;
        for (int i = start; i <= end; i++) {
            char c = str[i];
            if (c >= '0' && c <= '9') {
                res = 10 * res + (c - '0');
                if (res > 255) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder("25525511135");
        System.out.println(check(sb, 0, 0));
        restoreIpAddresses("25525511135");
    }
}
