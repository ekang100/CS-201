import java.util.Arrays;
import java.util.HashSet;

public class SandwichBar {
    public int whichOrder(String[] available, String[] orders){
       HashSet<String> avail = new HashSet<String>();
       for (String element : available) {
        avail.add(element);
       }

       
       for (int i = 0; i < orders.length; i++) {
        HashSet<String> order = new HashSet<String>(Arrays.asList(orders[i].split(" ")));
        order.removeAll(avail);
        if (order.size() == 0) {
            return i;
        }

       }

       return -1; 
    }
}
    