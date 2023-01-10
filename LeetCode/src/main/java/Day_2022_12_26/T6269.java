package Day_2022_12_26;

import org.junit.jupiter.api.Test;

/**
 * @author wak
 */
public class T6269 {
    @Test
    public void test() {
        String[] words = {"hello", "i", "am", "leetcode", "hello"};
        System.out.println(closetTarget(words, "hello", 1));
    }

    public int closetTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int k = Math.abs(i - startIndex);
                if (k == 0) {
                    return 0;
                }
                k = Math.min(k, n - k);
                ans = Math.min(ans, k);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
