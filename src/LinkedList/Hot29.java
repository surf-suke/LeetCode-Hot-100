package LinkedList;

public class Hot29 {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        if(n<=0) return head;
        ListNode p = head;
        ListNode ahead = p;
        ListNode pre=p;
        int steps= n-1;
        while(steps>0){
            if(ahead.next!=null){
                ahead=ahead.next;
                steps--;
            }
        }
        while(ahead.next!=null){
            pre=p;
            ahead=ahead.next;
            p=p.next;
        }
        if(pre==p){                  //说明要删除第一个，由于没有空白头节点所以要分类讨论
            head=head.next;
            return head;
        }
        pre.next=p.next;
        p.next=null;
        return head;
    }
}
