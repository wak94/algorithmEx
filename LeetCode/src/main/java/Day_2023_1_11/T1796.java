package Day_2023_1_11;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wak
 */
public class T1796 {

    @Test
    public void test() {
        System.out.println(secondHighest("dfa12321afd"));
    }

    public int secondHighest(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                set.add(Integer.parseInt(str[i] + ""));
            }
        }
        Object[] arr = set.toArray();
        if (arr.length == 1) {
            return -1;
        }
        return (int) arr[arr.length - 2];
    }
}
