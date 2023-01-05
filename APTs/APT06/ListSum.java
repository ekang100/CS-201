public class ListSum {
    public int sum(ListNode list, int thresh) {
        // replace statement below with code you write
        int rest = 0;
        ListNode curr = list;

        while (curr != null) {
            if (curr.info > thresh) {
                rest += curr.info;
            }
            curr = curr.next;
        }

        return rest;
    }
}