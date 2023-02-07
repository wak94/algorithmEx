package Day_2023_2_7;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wak
 */
public class T1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            char[] time = keyTime[i].toCharArray();
            int hours = (time[0] - '0') * 10 + (time[1] - '0');
            int minutes = (time[3] - '0') * 10 + (time[4] - '0');
            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(hours * 60 + minutes);
        }
        List<String> ans = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> list = map.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int t1 = list.get(i - 2);
                int t2 = list.get(i);
                if ((t2 - t1) <= 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    @Test
    public void test() {
        String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        alertNames(keyName, keyTime);
    }
}
