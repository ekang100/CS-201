import java.util.ArrayList;

public class Starter {
    public int begins(String[] words, String first) {
        int count = 0;
        ArrayList<String> seenWords = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (!seenWords.contains(words[i])) {
                seenWords.add(words[i]);
                if (words[i].startsWith(first)) {
                    count++;
                }
                
            }
        
            
        }

        return count;
    }
}

