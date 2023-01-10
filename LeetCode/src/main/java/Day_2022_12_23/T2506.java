package Day_2022_12_23;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author wak
 */
public class T2506 {

    @Test
    public void test() {
        String[] words = {"aba", "aabb", "abcd", "bac", "aabc"};
        System.out.println(similarPairs(words));
//        System.out.println(isPair("aba", "abcd"));
    }

    public int similarPairs(String[] words) {
        int ans = 0;
        int n = words.length;
        if (n == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += isPair(words[i], words[j]) ? 1 : 0;
            }
        }
        return ans;
    }

    public boolean isPair(String s1, String s2) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            set2.add(s2.charAt(i));
        }
        return set1.equals(set2);
    }
}
