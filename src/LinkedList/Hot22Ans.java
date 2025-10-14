package LinkedList;
public class Hot22Ans {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA != currentB) {
            currentA = getNext(currentA, headB);
            currentB = getNext(currentB, headA);
        }
        return currentA;
    }

    private ListNode getNext(ListNode current, ListNode head) {
        return current == null ? head : current.next;
    }
}