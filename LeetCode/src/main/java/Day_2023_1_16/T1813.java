package Day_2023_1_16;

import org.junit.jupiter.api.Test;

/**
 * @author wak
 */
public class T1813 {

    @Test
    public void test() {
        System.out.println(areSentencesSimilar("My name is Haley", "My Haley"));
        System.out.println(areSentencesSimilar("of", "A lot of words"));
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int len1 = words1.length;
        int len2 = words2.length;

        int i = 0, j = 0;
        //计算从左往右对应位置相等的单词个数
        while (i < len1 && i < len2 && words1[i].equals(words2[i])) {
            i++;
        }
        //计算从右往左对应位置相等的单词个数
        while (j < len1 - i && j < len2 - i && words1[len1 - j - 1].equals(words2[len2 - j - 1])) {
            j++;
        }
        //两边个数相加只有等于更小的单词数即为真
        return i + j == Math.min(len1, len2);
    }
}
