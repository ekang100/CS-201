import java.util.Arrays;
import java.util.List;

public class TxMsg {
    public String convert(String word) {
        StringBuilder convertWord = new StringBuilder();
        char[] chars = word.toCharArray();

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        if (!vowels.contains(chars[0])) {
            convertWord.append(chars[0]);
        }

        for (int i = 1; i < chars.length; i++) {
            if(!vowels.contains(chars[i]) && vowels.contains(chars[i - 1])) {
                convertWord.append(chars[i]);
            }
        }

        if (convertWord.length() == 0) {
            return word;
        } else {
            return convertWord.toString();
        }
    }
    
    
    public String getMessage(String original) {
        // code here
        String[] data = original.split(" ");
        String[] ret = new String[data.length];

        for (int k = 0; k < data.length; k++) {
            ret[k] = convert(data[k]);
        }
        return String.join(" ", ret);
            

      }
}
