package LinkedList;

public class Hot23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode p = head;
        ListNode q = head.next;
        p.next=null;
        while(q!=null){
            ListNode tmp =q.next;
            q.next=p;
            p=q;
            q=tmp;
        }
        return p;
    }
}
