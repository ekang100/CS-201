import java.util.HashMap;

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        // change this code
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        int[] ret = new int[words.length];

        for (String element : str.split(" ")) {
            if (!hash.containsKey(element)) {
                hash.put(element, 0);
            }
            hash.put(element, hash.get(element) + 1);
        }

        for (int i = 0; i < words.length; i++) {
            ret[i] = hash.getOrDefault(words[i], 0);
        }
    
        return ret;
    }
}