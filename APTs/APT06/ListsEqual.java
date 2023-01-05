public class ListsEqual {
    public int equal (ListNode a1, ListNode a2) {
        // replace statement below with code you write

        ListNode currA1 = a1;
        ListNode currA2 = a2;

        if (currA1 == null & currA2 != null) {
            return 0;
        }

        if (currA1 != null & currA2 == null) {
            return 0;
        }

        while (currA1 != null) {
            if (currA1.info != currA2.info) {
                return 0;
            }

            if (currA1.next == null ^ currA2.next == null) {
                return 0;
            }

            currA1 = currA1.next;
            currA2 = currA2.next;
        }

        return 1;
    
    }
}
