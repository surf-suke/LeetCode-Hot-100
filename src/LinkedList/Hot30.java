package LinkedList;

public class Hot30 {
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
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy=new ListNode(-1,head);
        head=dummy;
        ListNode pre = dummy;
        ListNode p=pre.next;
        ListNode q=p.next;
        ListNode post;
        while(q!=null){
            p.next=q.next;
            q.next=p;
            pre.next=q;
            post=q.next;
            pre=post;
            p=pre.next;
            if(p!=null)
                q=p.next;
            else
                break;
        }
        return head.next;
    }
}
