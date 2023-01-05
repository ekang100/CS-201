import java.util.*;
public class SortByFreqs {
    public String[] sort(String[] data) {
        // fill in code here
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String elem : data) {
            if (!map.containsKey(elem)) {
                map.put(elem, 0);
            }
            else {
                map.put(elem, map.get(elem) + 1);
            }
        }

        List <Map.Entry <String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, Map.Entry.comparingByKey());

        Collections.sort(list, (Map.Entry.comparingByValue(Comparator.reverseOrder())));

        String[] ret = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            ret[i] = entry.getKey();
        }

        return ret;


    }
 }