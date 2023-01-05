import java.util.*;
public class AlphaLength {
    public ListNode create (String[] words) {
        // replace statement below with code you write
        TreeSet<String> wordSet = new TreeSet<>(Arrays.asList(words));

        ListNode first = null;
        ListNode curr = null;

        for (String word : wordSet) {
            if (first == null) {
                first = new ListNode(word.length(), null);
                curr = first;
            }
            else {
                curr.next = new ListNode(word.length(), null);
                curr = curr.next;
            }
        }

        return first;
    }
}
