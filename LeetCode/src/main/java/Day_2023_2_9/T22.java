package Day_2023_2_9;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wak
 */
public class T22 {

    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0);
        return ans;
    }

    public void dfs(int n, int left, int right) {
        if (path.length() == 2 * n) {
            ans.add(path.toString());
            return;
        }
        //左括号可以直接加
        if (left < n) {
            path.append("(");
            dfs(n, left + 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        //右括号需要不多于左括号才能加,并且加完也要满足不超过左括号，因此需要严格小于才能加
        if (right<left){
            path.append(")");
            dfs(n,left,right+1);
            path.deleteCharAt(path.length() - 1);
        }
    }


    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }
}
