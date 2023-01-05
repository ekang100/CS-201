import java.util.*;

public class Closet {
    public String anywhere(String[] list) {
        // replace this with your code
        TreeSet<String> common = new TreeSet<String>();

        for (String word: list) {
            common.addAll(Arrays.asList(word.split(" ")));
        }
        return String.join(" ", common);
    }

}
