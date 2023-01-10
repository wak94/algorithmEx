package Day_2022_12_25;

/**
 * @author wak
 */
public class T2490 {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length - 1; i++) {
            int len = s[i].length();
            if (s[i].charAt(len - 1) != s[i + 1].charAt(0)) {
                return false;
            }
        }
        int len = s[s.length - 1].length();
        return s[s.length - 1].charAt(len - 1) == s[0].charAt(0);
    }
}
