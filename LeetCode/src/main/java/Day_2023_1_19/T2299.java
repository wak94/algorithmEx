package Day_2023_1_19;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wak
 */
public class T2299 {

    @Test
    public void test() {
        int a = 1;
    }

    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) {
            return false;
        }
        Set<Character> s = new HashSet<Character>() {
            {
                add('!');
                add('@');
                add('#');
                add('$');
                add('%');
                add('^');
                add('&');
                add('*');
                add('(');
                add(')');
                add('-');
                add('+');
            }
        };
        //n1 小写英文字母,n2 大写英文字母，n3 数字，n4 特殊字符
        int n1 = 0, n2 = 0, n3 = 0, n4 = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                n1++;
            }
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                n2++;
            }
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                n3++;
            }
            if (s.contains(password.charAt(i))) {
                n4++;
            }

        }
        return n1 >= 1 && n2 >= 1 && n3 >= 1 && n4 >= 1;
    }
}
