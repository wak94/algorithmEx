package Day_12_13;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author wak
 */
public class T20 {
    @Test
    public void test() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
    }

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        //符号入栈，遇到右括号判断栈顶是否为对应左括号，如果不是返回false
        //遍历完成后，如果栈不空也返回false
        char[] str = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(str[i])) {
                if (stack.isEmpty() || !stack.removeLast().equals(map.get(str[i]))) {
                    return false;
                }
            } else {
                stack.addLast(str[i]);
            }
        }
        return stack.isEmpty();
    }
}
