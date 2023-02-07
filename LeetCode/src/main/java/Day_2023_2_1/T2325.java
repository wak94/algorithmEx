package Day_2023_2_1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wak
 */
public class T2325 {

    @Test
    public void test() {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv"
        ));
    }

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();

        int k = 0;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            //当前字符为字母且未出现过
            if (ch != ' ' && !map.containsKey(ch)) {
                map.put(ch, (char) ('a' + k));
                k++;
            }
        }
        System.out.println(map);
        char[] ans = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch != ' ') {
                ans[i] = map.get(ch);
            } else {
                ans[i] = ' ';
            }
        }
        return new String(ans);
    }
}
