package LinkedList;

public class Hot26 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null) {
            slow = slow.next;
            if(fast.next!=null){
                fast = fast.next.next;
            }
            else
                return null;
            if (slow == fast) {
                ListNode ptr=head;
                while(ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
