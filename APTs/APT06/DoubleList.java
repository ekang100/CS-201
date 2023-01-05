public class DoubleList {
    public ListNode bigify(ListNode list) {
        // replace statement below with code you write
        ListNode temp;
        ListNode lst = list;

        while (list != null) {
            temp = new ListNode(list.info, list.next);
            list.next = temp;
            list = list.next.next;
        }

        return lst;
    }
}
