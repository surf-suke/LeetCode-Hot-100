package LinkedList;

public class Hot31 {
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(-1, head);
        head = dummy;
        ListNode pre = dummy;
        ListNode p=pre.next;
        ListNode q=p;
        ListNode post;
        ListNode tail;
        while(q!=null){
            int steps = k;
            while(steps>1 && q!=null){
                q=q.next;
                steps--;
            }
            if(q==null)
                break;
            post=q.next;
            tail=reverseList(p,k);
            p.next=post;
            pre.next=tail;
            pre=p;
            p=post;
            q=p;

        }
        return dummy.next;
    }
    public ListNode reverseList(ListNode head, int k){
        if(head==null || k<=0)
            return null;
        ListNode p =head;
        ListNode q = p.next;
        p.next=null;
        while(q!=null && k>1){
            ListNode tmp= q.next;
            q.next=p;
            p=q;
            q=tmp;
            k--;
        }
        return p;
    }

}
