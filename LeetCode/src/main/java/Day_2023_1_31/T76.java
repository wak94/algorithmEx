package Day_2023_1_31;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wak
 */
public class T76 {

    Map<Character, Integer> needs = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();



    public String minWindow(String s, String t) {

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        for (char c : str2) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = -1;
        int ansL = -1, ansR = -1;
        int sLen = str1.length;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (j < sLen) {
            j++;
            if (j < sLen && needs.containsKey(str1[j])) {
                window.put(str1[j], window.getOrDefault(str1[j], 0) + 1);
            }
            while (check() && i <= j) {
                if (j - i + 1 < len) {
                    len = j - i + 1;
                    ansL = i;
                    ansR = len + i;
                }
                if (needs.containsKey(str1[i])) {
                    window.put(str1[i], window.getOrDefault(str1[i], 0) - 1);
                }
                i++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        Iterator it = needs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();

            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (window.get(key) < value) {
                return false;
            }
        }
        return true;
    }
}
