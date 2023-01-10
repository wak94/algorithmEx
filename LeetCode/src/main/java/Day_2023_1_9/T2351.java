package Day_2023_1_9;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wak
 */
public class T2351 {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            //第一次遇到就添加，第二次遇到就返回
            if (!set.add(c)) {
                return c;
            }
        }
        return ' ';
    }
}
