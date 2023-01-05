import java.util.*;
public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary) {
          // fill in code here
          HashMap<String, Character> dict = new HashMap<>();
          for (int i = 0; i < dictionary.length; i++) {
            dict.put(dictionary[i], (char) (i + 65));
          }

          StringBuilder ret = new StringBuilder();
          char[] archive2 = archive.toCharArray();
          String curr = "";

          for (int i = 0; i < archive2.length; i++) {
            curr += archive2[i];

            if (dict.containsKey(curr)) {
                ret.append(dict.get(curr));
                curr = "";
            }
          }

          return ret.toString();
    }
 }