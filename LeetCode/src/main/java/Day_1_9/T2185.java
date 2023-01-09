package Day_1_9;

/**
 * @author wak
 */
public class T2185 {
        public int prefixCount(String[] words, String pref) {
            int ans = 0;
            for (String word : words) {
                if (word.length() >= pref.length() && word.startsWith(pref)) {
                    ans++;
                }
            }
            return ans;
        }
}
