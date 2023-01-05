//import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
    public int points(String[] player, String[] dictionary) {
        //HashSet<String> guess = new HashSet<>(Arrays.asList(dictionary));
        
        HashSet<String> guess = new HashSet<String>();
        for (String element: player) {
            guess.add(element);
        }

        int count = 0;

        for (String element : guess) {
            for (String item : dictionary) {
                if (element.equals(item)) {
                    int score = element.length() * element.length();
                    count = count + score;
                }
            }
        }
        return count;
      }
}
