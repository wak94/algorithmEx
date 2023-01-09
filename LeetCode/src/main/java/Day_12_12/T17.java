package Day_12_12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wak
 * 2 abc
 * 3 def
 * 4 ghi
 * 5 jkl
 * 6 mno
 * 7 pqrs
 * 8 tuv
 * 9 wxyz
 */
public class T17 {

    @Test
    public void solution() {
        letterCombinations("234").forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(list, map, 0, digits, new StringBuilder());
        return list;
    }

    public void backtrack(List<String> list, Map<Character, String> map, int index, String digits, StringBuilder sb) {
        if (index == digits.length()) {
            list.add(sb.toString());
        } else {
            char ch = digits.charAt(index);
            String letters = map.get(ch);
            int len = letters.length();
            for (int i = 0; i < len; i++) {
                sb.append(letters.charAt(i));
                backtrack(list, map, index + 1, digits, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
