import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BigWord {
    public String most(String[] sentences) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (int i = 0; i < sentences.length; i++) {
            String[] elements = sentences[i].split(" ");
            for (String element: elements) {
                if (!hash.containsKey(element.toLowerCase())) {
                    hash.put(element.toLowerCase(), 1);
                }
                hash.put(element.toLowerCase(), hash.get(element.toLowerCase()) + 1);
            }
        }
        return Collections.max(hash.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        
    }
}
