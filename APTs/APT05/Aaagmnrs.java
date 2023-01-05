import java.util.*;
public class Aaagmnrs {
    public String[] anagrams(String[] phrases) {
        // fill in code here
        HashMap<String, Integer> anagrams = new HashMap<>();

        for (int i = 0; i < phrases.length; i++) {
            String canonicalPhrase = isPerm(phrases[i]);

            anagrams.putIfAbsent(canonicalPhrase, i);
        }

        String[] result = new String[anagrams.size()];
        Integer[] index = anagrams.values().toArray(new Integer[0]);
        Arrays.sort(index);

        for(int i = 0; i < result.length; i++) {
            result[i] = phrases[index[i]];
        }

        return result;

    }

    private String isPerm(String word) {
        char[] characters = word.replaceAll("\\s", "").toLowerCase().toCharArray();

        Arrays.sort(characters);

        return new String(characters);
     }

}
