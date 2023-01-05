import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        // replace this with your code
        ArrayList<String> listArray = new ArrayList<>();
        ArrayList<String> retArray = new ArrayList<>();

        listArray.addAll((Arrays.asList(list)));

        for (int i = 0; i < listArray.size(); i++) {
            if (listArray.get(i).length() >= minLength && !(retArray.contains(listArray.get(i)))) {
                retArray.add(listArray.get(i));
            }
        }

        String[] ret = retArray.toArray(new String[0]);
        return ret;
    }
}