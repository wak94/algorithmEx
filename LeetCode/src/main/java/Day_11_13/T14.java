package Day_11_13;


import org.junit.jupiter.api.Test;


public class T14 {
    @Test
    public void test() {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                String s = strs[j];
                if (s == null || s.length() == 0) {
                    flag = false;
                    break;
                }
                if (i >= s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += strs[0].charAt(i);
            } else {
                break;
            }
        }
        return res;
    }
}
