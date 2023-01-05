import java.util.*;

public class SetAside {
    public String common(String[] list) {
        // replace this with your code
        TreeSet<String> common = new TreeSet<>(Arrays.asList(list[0].split(" ")));
        
        for (int i = 1; i < list.length; i++) {
            common.retainAll(Arrays.asList(list[i].split(" ")));
        }

        return String.join(" ", common);
    }
    
}
